import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int count = stdin.nextInt();
		int sum = 0;
		String s = stdin.next();
		String as[] = new String[count];
		as = s.split("");
		
		for(int i=0;i<as.length;i++) {
			sum += Integer.parseInt(as[i]);
		}
		System.out.println(sum);
	}
}
