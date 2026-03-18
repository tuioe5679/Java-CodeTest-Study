import java.util.Scanner;

public class Main {

    public static int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] words = input.split(" ");

        int first = 0;
        int second = 0;

        first = Integer.parseInt(words[0]);
        second = Integer.parseInt(words[1]);

        System.out.println(gcd(first, second));
        System.out.println(lcm(first, second));
    }
}