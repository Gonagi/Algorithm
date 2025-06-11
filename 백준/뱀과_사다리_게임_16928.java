import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int location, count;

        public Node(int location, int count) {
            this.location = location;
            this.count = count;
        }
    }

    static int N, M;
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> ladders = new HashMap<>();
        Map<Integer, Integer> snakes = new HashMap<>();

        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            ladders.put(from, to);
        }

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            snakes.put(from, to);
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(1, 0));
        visited[1] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int curLocation = cur.location;
            int curCount = cur.count;
            if (curLocation == 100) {
                bw.write(curCount + "\n");
                break;
            }

            for (int n = 1; n <= 6; n++) {
                int next = curLocation + n;
                if (next > 100) {
                    continue;
                }

                if (ladders.containsKey(next)) {
                    next = ladders.get(next);
                } else if (snakes.containsKey(next)) {
                    next = snakes.get(next);
                }

                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                que.add(new Node(next, curCount + 1));
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

