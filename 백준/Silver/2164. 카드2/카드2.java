import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> qu = new LinkedList<Integer>();

        int N = sc.nextInt();

        for(int i=1;i<=N;i++){
            qu.add(i);
        }

        while(qu.size() > 1){
            qu.poll();
            qu.add(qu.poll());
        }
        System.out.println(qu.poll());
    }
}