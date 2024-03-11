import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double a,b = 0;
        String[] s = br.readLine().split(" ");

        a = Double.parseDouble(s[0]);
        b = Double.parseDouble(s[1]);

        System.out.println(a/b);
    }
}
