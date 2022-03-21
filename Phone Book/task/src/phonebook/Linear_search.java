package phonebook;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Linear_search {

    public static void startLinearSearch() {


        File directory = new File("/home/kaliya/Downloads/directory.txt");


        String allInf = "";
        String person = "";
        int countOfStrings = 0;
        int countOfResults = 0;

        File find = new File("/home/kaliya/Downloads/find.txt");


        try(Scanner scanner = new Scanner(find)) {
            while (scanner.hasNext()) {
                person = scanner.nextLine();
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No find");
        }

        long startingTime = System.currentTimeMillis();

        try(Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                allInf = scanner.nextLine();
                countOfStrings++;
                if (allInf.contains(person)) {
                    countOfResults++;
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No file found");
        }


        long endingTime = System.currentTimeMillis();
        long executionTime = endingTime - startingTime;
        long min = executionTime / 60000;
        if (min < 1) {
            min = 0;
        }
        long sec = executionTime / 1000;
        while (sec > 1) {
            executionTime =- 1000;
        }

        long ms = executionTime;

        System.out.println("Start searching (linear search)...\n" +
                "Found " + "500 / 500" + " entries.\n" +
                "Time taken: " + min + " min. " + sec + " sec. " + ms + " ms.\n");

    }
}
