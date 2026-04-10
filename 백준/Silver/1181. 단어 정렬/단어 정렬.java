import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> s = new HashSet<>();

        for(int i = 0; i < n; i++){
            s.add(br.readLine());
        }

        List<String> list = new ArrayList<>(s);

        list.sort((o1,o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }else {
                return o1.length()-o2.length();
            }
        }) ;

        for(String str : list){
            bw.write(str+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}