import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        Set<Integer> S = new HashSet<>();

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String operations = st.nextToken();
            int x = 0;

            if(st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (operations) {
                case "add":
                    S.add(x);
                    break;
                case "remove":
                    S.remove(x);
                    break;
                case "check":
                    sb.append(S.contains(x) ? "1" : "0").append("\n");
                    break;
                case "toggle":
                    if (S.contains(x)) {
                        S.remove(x);
                    } else {
                        S.add(x);
                    }
                    break;
                case "all":
                    Set<Integer> D = new HashSet<>();
                    for (int j = 1; j < 21; j++) {
                        D.add(j);
                    }
                    S = new HashSet<>(D);
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}