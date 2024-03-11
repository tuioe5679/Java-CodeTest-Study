import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a,b = 0;
		String[] s = br.readLine().split(" ");
		
		a = Integer.parseInt(s[0]);
		b = Integer.parseInt(s[1]);
		
		System.out.println(a-b);
	}
}