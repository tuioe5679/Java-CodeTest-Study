import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String[] arr;
    static int[] len;
    static int[] modValue;
    static int[] pow10;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        len = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            len[i] = arr[i].length();
        }

        K = Integer.parseInt(br.readLine());

        modValue = new int[N];
        pow10 = new int[51]; // 길이 최대 50

        pow10[0] = 1 % K;
        for (int i = 1; i <= 50; i++) {
            pow10[i] = (pow10[i - 1] * 10) % K;
        }

        // 각 숫자를 K로 나눈 나머지 미리 계산
        for (int i = 0; i < N; i++) {
            modValue[i] = getMod(arr[i]);
        }

        int maxState = 1 << N;
        dp = new long[maxState][K];
        dp[0][0] = 1;

        for (int state = 0; state < maxState; state++) {
            for (int r = 0; r < K; r++) {
                if (dp[state][r] == 0) continue;

                for (int i = 0; i < N; i++) {
                    if ((state & (1 << i)) != 0) continue;

                    int nextState = state | (1 << i);
                    int nextR = (r * pow10[len[i]] + modValue[i]) % K;
                    dp[nextState][nextR] += dp[state][r];
                }
            }
        }

        long numerator = dp[maxState - 1][0];
        long denominator = factorial(N);

        long g = gcd(numerator, denominator);
        System.out.println((numerator / g) + "/" + (denominator / g));
    }

    static int getMod(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = (result * 10 + (s.charAt(i) - '0')) % K;
        }
        return result;
    }

    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}