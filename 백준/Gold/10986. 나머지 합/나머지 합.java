import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());

        long sum = 0;
        long result = 0;

        count[0] = 1;

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            int mod = (int)(sum % M);

            result += count[mod];
            count[mod]++;
        }

        System.out.println(result);
    }
}