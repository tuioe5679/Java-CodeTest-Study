import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0;i < num;i++) {
            if(isCheckString(br.readLine())){
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }

    private static boolean isCheckString(String s) {
        boolean[] alphabet = new boolean[26];

        for(int i = 0;i < s.length();i++) {
            int now = s.charAt(i) - 'a';
            int prev = (i > 0) ? s.charAt(i - 1) - 'a' : 0;
            if(!alphabet[now]) {
                alphabet[now] = true;
            }else if(now!=prev) {
                return false;
            }
        }
        return true;
    }
}