import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int H = Integer.parseInt(st.nextToken());
            st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            if(N % H==0){
                sb.append((H*100) + (N/H) +"\n");
            }else{
                sb.append((N%H*100) + ((N/H)+1) + "\n");
            }
        }
        System.out.println(sb);
    }
}