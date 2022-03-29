package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static phonebook.JumpingBubbles.bubbleSort;
import static phonebook.JumpingBubbles.jumpSearch;
import static phonebook.Linear_search.runLinearSearch;
import static phonebook.Main.informationList;
import static phonebook.Phonebook.*;


public class Main {

    static List<Contact> informationList = new ArrayList<>();
    static List<String> findList = new ArrayList<>();

    public static void main(String[] args) {

        run();

    }

    public static void run() {
        fillFindList();
        fillInformationList();

        System.out.println("Start searching (linear search)...\n");
        long linearSearchTime = runLinearSearch();
        System.out.print("Time taken: " + timer(linearSearchTime));

        long timeLimit = linearSearchTime * 10;
        System.out.println("\n");
        System.out.println("Start searching (bubble sort + jump search)...");
        jumpSearch(timeLimit);
    }


    public static String timer(long time) {

        StringBuilder timeKeeper = new StringBuilder();

        long ms = time % 1000;
        long sec = time / 1000 % 60;
        long min = time / 1000 / 60;

        timeKeeper.append(min);
        timeKeeper.append(" min. ");
        timeKeeper.append(sec);
        timeKeeper.append(" sec. ");
        timeKeeper.append(ms);
        timeKeeper.append(" ms. ");

        return timeKeeper.toString();
    }

}

class Phonebook {

    public static void fillInformationList() {

        File directory = new File("/home/kaliya/Downloads/small_directory.txt");
        //"directory.txt");


        try(Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                int curNumber = scanner.nextInt();
                String curName = scanner.nextLine().trim();
                informationList.add(new Contact(curName, curNumber));
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No directory-file found: " + exception.getMessage());
        }
    }

    public static void fillFindList() {
        File find = new File("/home/kaliya/Downloads/small_find.txt");
        //"find.txt");

        try (Scanner scanner = new Scanner(find)){
            while (scanner.hasNext()) {
                Main.findList.add(scanner.nextLine().trim());
            }
        } catch (FileNotFoundException exception) {
            System.out.println("No find-file found: " + exception.getMessage());
        }
    }

}

class Contact {
    String name;
    int number;

    public Contact (String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}

