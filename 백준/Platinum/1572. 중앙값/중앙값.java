import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 65536;
    static int[] tree = new int[MAX * 4];

    static void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || idx > end) return;

        tree[node] += diff;

        if (start == end) return;

        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid + 1, end, idx, diff);
    }

    static int query(int node, int start, int end, int k) {
        if (start == end) return start;

        int mid = (start + end) / 2;

        if (tree[node * 2] >= k) {
            return query(node * 2, start, mid, k);
        } else {
            return query(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        int medianOrder = (K + 1) / 2;

        for (int i = 0; i < K - 1; i++) {
            update(1, 0, MAX - 1, arr[i], 1);
        }

        for (int i = K - 1; i < N; i++) {
            update(1, 0, MAX - 1, arr[i], 1);

            int median = query(1, 0, MAX - 1, medianOrder);
            answer += median;

            update(1, 0, MAX - 1, arr[i - K + 1], -1);
        }

        System.out.println(answer);
    }
}