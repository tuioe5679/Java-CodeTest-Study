import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner stdin = new Scanner(System.in);
        int count = stdin.nextInt();
        int[] subject = new int[count];

        for(int i=0;i<count;i++){
            subject[i] = stdin.nextInt();
        }
        
        long max = 0;
        long sum = 0;

        for(int i=0;i<count;i++){
            if(max<subject[i]){
                max = subject[i];
            }
            sum += subject[i];
        }

        System.out.println(sum*100.0/max/count);
    }
}