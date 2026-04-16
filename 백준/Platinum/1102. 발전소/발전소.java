import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    static int N, P;
    static int[][] cost;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String state = br.readLine();
        P = Integer.parseInt(br.readLine());

        int mask = 0;
        int onCount = 0;

        for (int i = 0; i < N; i++) {
            if (state.charAt(i) == 'Y') {
                mask |= (1 << i);
                onCount++;
            }
        }

        if (P == 0) {
            System.out.println(0);
            return;
        }

        if (onCount >= P) {
            System.out.println(0);
            return;
        }

        if (onCount == 0) {
            System.out.println(-1);
            return;
        }

        dp = new int[1 << N];
        Arrays.fill(dp, -1);

        int answer = dfs(mask);

        System.out.println(answer >= INF ? -1 : answer);
    }

    static int dfs(int mask) {
        int count = Integer.bitCount(mask);

        if (count >= P) return 0;
        if (dp[mask] != -1) return dp[mask];

        int min = INF;

        // 현재 켜진 발전소 i를 이용해서 꺼진 발전소 j를 켠다
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) continue;

            for (int j = 0; j < N; j++) {
                if ((mask & (1 << j)) != 0) continue;

                int nextMask = mask | (1 << j);
                min = Math.min(min, cost[i][j] + dfs(nextMask));
            }
        }

        return dp[mask] = min;
    }
}