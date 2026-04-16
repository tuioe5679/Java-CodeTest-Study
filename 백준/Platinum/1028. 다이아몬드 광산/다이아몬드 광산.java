import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] downLeft;
    static int[][] downRight;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R + 2][C + 2];
        downLeft = new int[R + 2][C + 2];
        downRight = new int[R + 2][C + 2];

        for (int i = 1; i <= R; i++) {
            String line = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        // 아래 방향 대각선 길이 DP
        for (int i = R; i >= 1; i--) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] == '1') {
                    downLeft[i][j] = downLeft[i + 1][j - 1] + 1;
                    downRight[i][j] = downRight[i + 1][j + 1] + 1;
                }
            }
        }

        int answer = 0;

        // (i, j)를 다이아몬드의 꼭대기라고 보고 검사
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] == '0') continue;

                int possible = Math.min(downLeft[i][j], downRight[i][j]);

                for (int size = possible; size > answer; size--) {
                    int leftR = i + size - 1;
                    int leftC = j - size + 1;
                    int rightR = i + size - 1;
                    int rightC = j + size - 1;

                    if (leftR > R || rightR > R || leftC < 1 || rightC > C) continue;

                    // 왼쪽 꼭짓점에서 오른쪽 아래 변 길이 확인
                    // 오른쪽 꼭짓점에서 왼쪽 아래 변 길이 확인
                    if (downRight[leftR][leftC] >= size && downLeft[rightR][rightC] >= size) {
                        answer = size;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}