import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("long ");
		
		int intPutValue = 0;
	    int value = 0;
	    
		String[] s = br.readLine().split(" ");
		intPutValue = Integer.parseInt(s[0]);
		
		value = intPutValue/4;
		
		for(int i = 0;i<value-1; i++){
		    sb.append("long ");
		}
		
		sb.append("int");
		System.out.println(sb);
	}
}