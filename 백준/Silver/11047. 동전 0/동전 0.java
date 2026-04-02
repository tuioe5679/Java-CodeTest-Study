import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k,count = 0;

        String[] inputArrays = br.readLine().split(" ");
        n = Integer.parseInt(inputArrays[0]);
        k = Integer.parseInt(inputArrays[1]);

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = n-1; i >= 0; i--){
            count += k/arr[i];
            k = k%arr[i];
        }

        System.out.println(count);
    }
}