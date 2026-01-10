import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int[] array = new int[3];

        for(int i = 0; i < array.length; i++) {
            array[i] = stdin.nextInt();
        }

        System.out.println((array[0] + array[1]) - array[2]);
        String sum = Integer.toString(array[0]) + array[1];
        System.out.println(Integer.parseInt(sum) - array[2]);
    }
}