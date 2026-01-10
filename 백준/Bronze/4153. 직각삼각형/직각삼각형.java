import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void check(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);

        long x = array[0];
        long y = array[1];
        long z = array[2];

        long right = (x * x) + (y * y);
        long left = (z * z);

        if(right == left) {
            System.out.println("right");
        }
        else {
            System.out.println("wrong");
        }
    }
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int[] array = new int[3];

        while(true) {
            for(int i = 0; i < 3; i++) {
                array[i] = stdin.nextInt();
            }
            if(array[0] == 0 && array[1] == 0 && array[2] == 0) {
                break;
            }
            check(array[0],array[1],array[2]);
        }
    }
}