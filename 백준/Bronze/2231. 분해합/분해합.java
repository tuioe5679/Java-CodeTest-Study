import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int result = 0;

        // 완전 탐색
        for(int i=0;i<input;i++){
            int sum = i;
            int temp = i;

            // 각 자릿수를 더하기
            while(temp>0) {
                sum += temp % 10;
                temp /= 10;
            }

            // 생성자가 맞다면
            if(sum == input) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}