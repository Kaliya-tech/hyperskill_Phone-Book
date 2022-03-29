import java.util.Scanner;

public class Main {

    public static int comb(int n, int k) {
        // write your code here

        if (k == 0) {
            return 1;
        } else if (k > n) {
            return 0;
        } else {
            return factorial(n) / (factorial(k) * factorial(n - k));
        }
    }

    public static int factorial(int a) {
        if (a == 0 || a == 1) {
            return 1;
        } else {

            return a * factorial(a - 1);

        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        System.out.println(comb(n, k));
    }
}