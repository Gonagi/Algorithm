import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<Integer>[] lists;
    static int[] colors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= K; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            lists = new ArrayList[V + 1];
            colors = new int[V + 1];
            boolean check = true;

            for (int idx = 1; idx <= V; idx++) {
                lists[idx] = new ArrayList<>();
            }

            for (int idx = 0; idx < E; idx++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                lists[v1].add(v2);
                lists[v2].add(v1);
            }

            for (int num = 1; num <= V; num++) {
                if (colors[num] == 0 && !bfs(num)) {
                    check = false;
                    break;
                }
            }
            System.out.println(check ? "YES" : "NO");
        }
        br.close();
    }

    static boolean bfs(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        colors[start] = 1;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : lists[cur]) {
                if (colors[next] == -1 * colors[cur]) {
                    continue;
                }
                if (colors[cur] == colors[next]) {
                    return false;
                }
                colors[next] = -1 * colors[cur];
                que.add(next);
            }
        }
        return true;
    }
}
