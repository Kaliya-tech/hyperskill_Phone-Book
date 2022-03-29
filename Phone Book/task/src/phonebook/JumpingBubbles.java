package phonebook;
import java.util.List;

import static phonebook.Linear_search.runLinearSearch;
import static phonebook.Main.*;

public class JumpingBubbles {


    public static long bubbleSort(long timeLimit) {

        long bubbleSortStartingTime = System.currentTimeMillis();

        for (int i = 0; i < informationList.size(); i++) {
            if (System.currentTimeMillis() - bubbleSortStartingTime >= timeLimit) {
                break;
            }
            for (int j = i + 1; j < informationList.size(); j++) {
                if (informationList.get(j).name.compareTo(informationList.get(i).name) > 0) {
                    Contact curr = informationList.get(j);
                    informationList.set(i, informationList.get(j));
                    informationList.set(j, curr);
                }
            }
        }

        return System.currentTimeMillis() - bubbleSortStartingTime;

    }

    public static void jumpSearch(long timeLimit) {

        long startingTime = System.currentTimeMillis();
        long sortingTime = bubbleSort(timeLimit);

        if (startingTime < timeLimit) {
            long searchStartTime = System.currentTimeMillis();
            int block = (int) Math.floor(Math.sqrt(informationList.size()));

            int count = 0;
            for (String name : findList) {
                int lastIndex = block - 1;

                while (lastIndex < informationList.size()
                        && name.compareTo(informationList.get(lastIndex).getName()) > 0) {
                    lastIndex += block;
                }
                for( int i = lastIndex - block + 1; i <= lastIndex && i < informationList.size(); i++) {
                    if (name.equals(informationList.get(i).getName())) {
                        count++;
                        break;
                    }
                }
            }
            long totalSearchingTime = System.currentTimeMillis() - searchStartTime;
            long dur = System.currentTimeMillis() - startingTime;

            System.out.println("Found " + count + " / " + findList.size() + " entries. Time taken: " + timer(dur));
            System.out.println("Sorting time: " + timer(sortingTime));
            System.out.println("Searching time: " + timer(totalSearchingTime));

        } else {
            long linearSearch = runLinearSearch();
            long dur = System.currentTimeMillis() - startingTime;

            System.out.print("Time taken: " + timer(dur));
            System.out.println();
            System.out.println("Sorting time: " + timer(sortingTime) + " - Stop and move to linear search");
            System.out.println("Searching time: " + timer(linearSearch));
        }
    }
}
