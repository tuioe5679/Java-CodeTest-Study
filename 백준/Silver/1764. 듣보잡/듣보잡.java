import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String name = br.readLine();

            if(set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");

        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}