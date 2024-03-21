import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," "); 
        int[] input = new int[8];
        String result = "mixed";

        for(int i=0;i<input.length;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<input.length;i++){
            if(input[0]==1){
                if(input[i] == i+1){
                    result = "ascending";
                }else{
                    result = "mixed";
                    break;
                }
            }else if(input[0]==8){
                if(input[i] == 8-i){
                    result = "descending";
                }else{
                    result = "mixed";
                    break;
                }
            }
            else{
                break;
            }
        }
        System.out.println(result);
    }
}

