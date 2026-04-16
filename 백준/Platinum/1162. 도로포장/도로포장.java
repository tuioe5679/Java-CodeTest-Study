import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        long cost;

        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        int node;
        int paved;
        long dist;

        State(int node, int paved, long dist) {
            this.node = node;
            this.paved = paved;
            this.dist = dist;
        }

        @Override
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    static final long INF = Long.MAX_VALUE;
    static int N, M, K;
    static List<Edge>[] graph;
    static long[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        dist = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        dijkstra();

        long answer = INF;
        for (int i = 0; i <= K; i++) {
            answer = Math.min(answer, dist[N][i]);
        }

        System.out.println(answer);
    }

    static void dijkstra() {
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[1][0] = 0;
        pq.offer(new State(1, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.dist > dist[cur.node][cur.paved]) continue;

            for (Edge next : graph[cur.node]) {
                // 포장하지 않고 이동
                long nextDist = cur.dist + next.cost;
                if (dist[next.to][cur.paved] > nextDist) {
                    dist[next.to][cur.paved] = nextDist;
                    pq.offer(new State(next.to, cur.paved, nextDist));
                }

                // 포장하고 이동
                if (cur.paved < K && dist[next.to][cur.paved + 1] > cur.dist) {
                    dist[next.to][cur.paved + 1] = cur.dist;
                    pq.offer(new State(next.to, cur.paved + 1, cur.dist));
                }
            }
        }
    }
}