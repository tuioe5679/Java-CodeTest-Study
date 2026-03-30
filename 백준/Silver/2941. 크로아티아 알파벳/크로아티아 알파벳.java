import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] croatias = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String str = br.readLine();

        for(String croatie : croatias) {
            if(str.contains(croatie)){
                str = str.replace(croatie,"*");
            }
        }

        System.out.println(str.length());
    }
}