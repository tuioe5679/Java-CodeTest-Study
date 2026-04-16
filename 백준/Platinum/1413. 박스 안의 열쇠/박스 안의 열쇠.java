import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger[][] dp = new BigInteger[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], BigInteger.ZERO);
        }

        dp[0][0] = BigInteger.ONE;

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= n; k++) {
                // dp[n][k] = dp[n-1][k-1] + (n-1) * dp[n-1][k]
                dp[n][k] = dp[n - 1][k - 1].add(
                        dp[n - 1][k].multiply(BigInteger.valueOf(n - 1L))
                );
            }
        }

        BigInteger numerator = BigInteger.ZERO;
        for (int k = 1; k <= M; k++) {
            numerator = numerator.add(dp[N][k]);
        }

        BigInteger denominator = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            denominator = denominator.multiply(BigInteger.valueOf(i));
        }

        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        System.out.println(numerator + "/" + denominator);
    }
}