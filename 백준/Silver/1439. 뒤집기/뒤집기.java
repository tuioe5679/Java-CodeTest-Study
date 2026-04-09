import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int zero = 0;
        int one = 0;

        char prev = input.charAt(0);

        if(prev == '0') {
            zero++;
        } else {
            one++;
        }

        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i) != prev) {
                if(input.charAt(i) == '0') {
                    zero++;
                }else {
                    one++;
                }
                prev = input.charAt(i);
            }
        }

        bw.write(Math.min(zero, one)+"");

        br.close();
        bw.flush();
        bw.close();
    }
}