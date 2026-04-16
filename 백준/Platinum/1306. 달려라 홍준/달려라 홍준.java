import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int windowSize = 2 * M - 1;

        for (int i = 0; i < N; i++) {
            // 현재 값보다 작은 인덱스들은 뒤에서 제거
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            // 윈도우 범위를 벗어난 인덱스 제거
            while (!dq.isEmpty() && dq.peekFirst() <= i - windowSize) {
                dq.pollFirst();
            }

            // 윈도우가 완성되면 최대값 출력
            if (i >= windowSize - 1) {
                sb.append(arr[dq.peekFirst()]).append(' ');
            }
        }

        System.out.println(sb);
    }
}