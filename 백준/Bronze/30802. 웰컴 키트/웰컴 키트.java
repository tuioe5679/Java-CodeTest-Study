import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int[] size = new int[6];
        int N = stdin.nextInt();

        int orderT = 0;

        for (int i = 0; i < size.length; i++) {
            size[i] = stdin.nextInt();
        }

        int T = stdin.nextInt();
        int P = stdin.nextInt();

        for (int i = 0; i < size.length; i++) {
            orderT += size[i]/T;
            if(size[i]%T != 0) {
                orderT++;
            }
        }

        int orderP  = N/P;
        int orderOneP = N%P;

        System.out.println(orderT);
        System.out.println(orderP + " " +orderOneP);
    }
}