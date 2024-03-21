import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," "); 
        int[] input = new int[5];
        int sum = 0;
        for(int i=0;i<input.length;i++){
            input[i] = Integer.parseInt(st.nextToken());
            sum += input[i] * input[i];
        }
        System.out.println(sum%10);
    }
}