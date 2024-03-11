import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
        
		int numbers[] = new int[30];
        int assignemnt[] = new int[2];
        int count = 0;
        
		for(int i=0;i<28;i++) {
			numbers[stdin.nextInt()-1] = 1;
		}
        
		for(int i=0;i<numbers.length;i++) {
		    if(numbers[i]!=1){
		        assignemnt[count] = i+1;
		        count++;
		    }
		}
        
		Arrays.sort(assignemnt);
        
		for(int i=0;i<2;i++){
		    System.out.println(assignemnt[i]);
		}
	}
}

