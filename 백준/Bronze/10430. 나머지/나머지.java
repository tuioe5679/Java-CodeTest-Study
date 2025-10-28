import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int value[] = new int[3];

        for (int i = 0; i < value.length; i++) {
            value[i] = stdin.nextInt();
        }

        System.out.println((value[0] + value[1]) % value[2]);
        System.out.println(((value[0] % value[2]) + (value[1] % value[2])) % value[2]);
        System.out.println((value[0] * value[1]) % value[2]);
        System.out.println(((value[0] % value[2]) * (value[1] % value[2])) % value[2]);
    }
}