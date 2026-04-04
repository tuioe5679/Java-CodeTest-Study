import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0;i < t;i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();

            for(int j = 0;j < n;j++) {
                String[] arr = br.readLine().split(" ");
                map.put(arr[1],map.getOrDefault(arr[1],0)+1);
            }

            int count = 1;

            for(int value:map.values()) {
                count *= (value+1);
            }
            sb.append(count-1).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}