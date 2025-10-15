import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] D;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int idx = 1; idx <= N; idx++) {
                D[idx] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList[N + 1];
            for (int idx = 1; idx <= N; idx++) {
                graph[idx] = new ArrayList<>();
            }

            int[] count = new int[N + 1];
            for (int idx = 0; idx < K; idx++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                count[to]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> que = new ArrayDeque<>();
            int[] result = new int[N + 1];
            for (int cur = 1; cur <= N; cur++) {
                if (count[cur] == 0) {
                    que.add(cur);
                }
                result[cur] = D[cur];
            }

            while (!que.isEmpty()) {
                int cur = que.poll();
                for (int next : graph[cur]) {
                    if (result[next] < result[cur] + D[next]) {
                        result[next] = result[cur] + D[next];
                    }
                    count[next]--;

                    if (count[next] == 0) {
                        que.add(next);
                    }
                }
            }

            bw.write(result[W] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

