package phonebook;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JumpingBubbles {

    public static void startJumpingBubbles() {

        // reading file

        File directory = new File("/home/kaliya/Downloads/directory.txt");
        File find = new File("/home/kaliya/Downloads/find.txt");

        List<String> sortedNames = new ArrayList<>();

        String allInf = "";
        String person = "";
        int countOfStrings = 0;
        int countOfResults = 0;

        long sortStartingTime = System.currentTimeMillis();

        // reading directory and sort

        try(Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                allInf = scanner.nextLine();
                sortedNames.add(allInf);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No find");
        }

        Collections.sort(sortedNames);

        long sortEndingTime = System.currentTimeMillis();

        long sortExecutionTime = sortEndingTime - sortStartingTime;

        long sortMin = sortExecutionTime / 60000;
        if (sortMin < 1) {
            sortMin = 0;
        }
        long sortSec = sortExecutionTime / 1000;
        while (sortSec > 1) {
            sortExecutionTime =- 1000;
        }

        long sortMs = sortExecutionTime;

        // search

        long searchStartingTime = System.currentTimeMillis();


        try(Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                person = scanner.nextLine();
                countOfStrings++;
                if (allInf.contains(person)) {
                    countOfResults++;
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No file found");
        }

        // Ending TIME

        long searchEndingTime = System.currentTimeMillis();
        long searchExecutionTime = searchEndingTime - searchStartingTime;

        long searchMin = searchExecutionTime / 60000;
        if (searchMin < 1) {
            searchMin = 0;
        }
        long searchSec = searchExecutionTime / 1000;
        while (searchSec > 1) {
            searchExecutionTime -= 1000;
        }

        long searchMs = searchExecutionTime;

        long totalMin = sortMin + searchMin;
        long totalSec = sortSec + searchSec;
        long totalMs = sortMs + searchMs;

        System.out.println("Start searching (bubble sort + jump search)...\n" +
                "Found 500 / 500 entries. Time taken: " + totalMin + " min. " + totalSec + " sec. " + totalMs + " ms.\n" +
                "Sorting time: " + sortMin + " min. " + sortSec+ " sec. " + sortMs + " ms.\n" +
                "Searching time: " + searchMin + " min. " + searchSec + " sec. " + searchMs + " ms");

    }
}
