import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        queue = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }

    static void push(int a) {
        queue.add(a);
    }

    static void pop() {
        if(queue.isEmpty()) {
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.remove()).append("\n");
        }
    }

    static void size() {
        sb.append(queue.size()).append("\n");
    }

    static void empty() {
        if(queue.isEmpty()) {
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }

    static void front() {
        if(queue.isEmpty()) {
            sb.append("-1").append("\n");
        }
        else {
            sb.append(queue.peek()).append("\n");
        }
    }

    static void back() {
        if(queue.isEmpty()) {
            sb.append("-1").append("\n");
            return;
        }

        int n = queue.size();

        for (int i = 1; i <= n-1; i++) {
            queue.add(queue.remove());
        }

        sb.append(queue.peek()).append("\n");
        queue.add(queue.remove());
    }
}