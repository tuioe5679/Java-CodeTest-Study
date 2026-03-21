import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int input = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0;i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a != 0) {
                stack.push(a);
            } else {
                stack.pop();
            }
        }

        for (Integer integer : stack) {
            result += integer;
        }

        sb.append(result);
        System.out.println(sb);
    }
}