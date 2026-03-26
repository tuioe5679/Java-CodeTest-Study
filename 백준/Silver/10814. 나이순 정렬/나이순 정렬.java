import java.io.*;
import java.util.*;

class Member {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Member> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new Member(age, name));
        }

        // 나이 기준 정렬 (stable sort)
        Collections.sort(list, (a, b) -> a.age - b.age);

        StringBuilder sb = new StringBuilder();

        for (Member m : list) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }

        System.out.print(sb);
    }
}