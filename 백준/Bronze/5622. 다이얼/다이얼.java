import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] time = {
                3,3,3,    // ABC
                4,4,4,    // DEF
                5,5,5,    // GHI
                6,6,6,    // JKL
                7,7,7,    // MNO
                8,8,8,8,  // PQRS
                9,9,9,    // TUV
                10,10,10,10 // WXYZ
        };

        int sum = 0;

        String input = sc.nextLine();

        for(char c: input.toCharArray()) {
            sum += time[c - 'A'];
        }

        System.out.println(sum);
    }
}