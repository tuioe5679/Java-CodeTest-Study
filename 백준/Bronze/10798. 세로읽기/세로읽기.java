import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] arrays = new char[5][15];

        for (int i = 0; i < arrays.length; i++) {
            String line = br.readLine();
            if (line == null) line = "";
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length && j < arrays[i].length; j++) {
                arrays[i][j] = chars[j];
            }
        }
        br.close();

        for (int j = 0; j < arrays[0].length; j++) {
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i][j] != '\0') {
                    sb.append(arrays[i][j]);
                }
            }
        }
        System.out.println(sb);
    }
}
