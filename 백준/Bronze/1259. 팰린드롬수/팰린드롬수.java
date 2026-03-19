import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if(s.equals("0")) break;

            boolean isPalindrome = true;

            int left = 0;
            int right = s.length()-1;

            while(left < right) {
                if(s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break;
                }

                left++;
                right--;
            }

            if(isPalindrome) {
                sb.append("yes\n");
            }else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}