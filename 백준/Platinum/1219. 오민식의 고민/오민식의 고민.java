import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to;
        long cost;

        Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long NEG_INF = Long.MIN_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            edges.add(new Edge(s, e, c));
            graph[s].add(e);
        }

        long[] earn = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            earn[i] = Long.parseLong(st.nextToken());
        }

        long[] dist = new long[N];
        Arrays.fill(dist, NEG_INF);
        dist[start] = earn[start];

        // 일반 벨만-포드
        for (int i = 0; i < N - 1; i++) {
            boolean updated = false;

            for (Edge edge : edges) {
                if (dist[edge.from] == NEG_INF) continue;

                long nextMoney = dist[edge.from] - edge.cost + earn[edge.to];
                if (dist[edge.to] < nextMoney) {
                    dist[edge.to] = nextMoney;
                    updated = true;
                }
            }

            if (!updated) break;
        }

        // 도착 자체가 불가능
        if (dist[end] == NEG_INF) {
            System.out.println("gg");
            return;
        }

        // N번째에서도 갱신되는 정점 찾기
        boolean[] cycle = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] == NEG_INF) continue;

                long nextMoney = dist[edge.from] - edge.cost + earn[edge.to];
                if (dist[edge.to] < nextMoney) {
                    dist[edge.to] = nextMoney;
                    cycle[edge.to] = true;
                    cycle[edge.from] = true;
                }

                // 이미 사이클 영향권이면 전파
                if (cycle[edge.from]) {
                    cycle[edge.to] = true;
                }
            }
        }

        // 사이클 영향권 정점에서 end로 갈 수 있는지 확인
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (cycle[i]) {
                q.offer(i);
                visited[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == end) {
                System.out.println("Gee");
                return;
            }

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        System.out.println(dist[end]);
    }
}