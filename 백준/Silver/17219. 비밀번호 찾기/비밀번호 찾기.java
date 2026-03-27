import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<String,String> sitePassword = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            sitePassword.put(line[0],line[1]);
        }

        for(int i = 0; i < M; i++) {
            sb.append(sitePassword.get(br.readLine())).append('\n');
        }

        System.out.print(sb);
    }
}