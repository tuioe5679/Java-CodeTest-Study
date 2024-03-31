import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine());
        int A[] = new int[N]; 

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);

        int i = 0;  
        int j = N-1;
        int count = 0;

        while(i<j){
            if(A[i]+A[j]>M){
                j--;
            }else if(A[i]+A[j]<M){
                i++;
            }else{
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}

