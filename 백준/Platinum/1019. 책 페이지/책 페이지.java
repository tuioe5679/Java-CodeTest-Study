import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] count = new long[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        solve(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(count[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void solve(long N) {
        long start = 1;
        long end = N;
        long point = 1; 

        while (start <= end) {

            while (end % 10 != 9 && start <= end) {
                calc(end, point);
                end--;
            }

            if (start > end) break;

            while (start % 10 != 0 && start <= end) {
                calc(start, point);
                start++;
            }

            start /= 10;
            end /= 10;

            long diff = end - start + 1;

            for (int i = 0; i < 10; i++) {
                count[i] += diff * point;
            }

            point *= 10;
        }
    }

    static void calc(long x, long point) {
        while (x > 0) {
            count[(int)(x % 10)] += point;
            x /= 10;
        }
    }
}