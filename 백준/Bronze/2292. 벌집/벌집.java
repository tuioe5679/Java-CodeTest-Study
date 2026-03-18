import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int max = 1;    // 층
        int count = 1;  // 현재 층의 최대값

        while(input > max) {
            max += count * 6;
            count++;
        }

        System.out.println(count);
    }
}