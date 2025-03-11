import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        String sNum = stdin.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (char c : cNum) {
            sum += c - '0';
        }
        System.out.print(sum);
    }
}
