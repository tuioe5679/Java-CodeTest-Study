import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[] = new int[N];

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int a = 0; a < k; a++) {
                for (int b = (i-1); b < (j); b++) {
                    A[b] = k;
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(A[i]+" ");
        }
        br.close();
    }
}
