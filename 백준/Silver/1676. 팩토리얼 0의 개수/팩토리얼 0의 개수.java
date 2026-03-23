import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int count = 0;
        while(input >= 5) {
            count += input / 5;
            input /= 5;
        }
        System.out.println(count);
    }
}