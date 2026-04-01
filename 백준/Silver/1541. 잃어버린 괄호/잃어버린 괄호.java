import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ceremony = br.readLine();
        String[] ceremonyArray = ceremony.split("-");
        
        int result = 0;
        result += sum(ceremonyArray[0]);

        for(int i = 1; i < ceremonyArray.length; i++) {
            result -= sum(ceremonyArray[i]);
        }

        System.out.println(result);
    }

    public static int sum(String number) {
        int sum = 0;
        String[] numberArray = number.split("\\+");
        
        for (String s : numberArray) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}