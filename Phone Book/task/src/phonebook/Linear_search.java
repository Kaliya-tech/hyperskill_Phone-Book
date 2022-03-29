package phonebook;

import static phonebook.Main.findList;
import static phonebook.Main.informationList;

public class Linear_search {

    public static long runLinearSearch() {

        long linearTimer = System.currentTimeMillis();

        int countOfResults = 0;

        for (String str : findList) {
            for (Contact person : informationList) {
                if (str.equals(person.name)) {
                    countOfResults++;
                    if (countOfResults == informationList.size()) {
                        break;
                    }
                }
            }

        }

        linearTimer = System.currentTimeMillis() - linearTimer;

        System.out.println("Found " + countOfResults + " / " + informationList.size() + " entries. Time taken: ");

        return linearTimer;
    }
}
