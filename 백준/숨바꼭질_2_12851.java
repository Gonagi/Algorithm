import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dist = new int[100001];
        int[] count = new int[100001];

        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> que = new ArrayDeque<>();
        que.add(N);
        dist[N] = 0;
        count[N] = 1;

        while (!que.isEmpty()) {
            int cur = que.poll();
            int[] nexts = {cur * 2, cur + 1, cur - 1};
            for (int next : nexts) {
                if (next < 0 || next >= 100001) {
                    continue;
                }

                if (dist[next] == Integer.MAX_VALUE) {
                    dist[next] = dist[cur] + 1;
                    count[next] = count[cur];
                    que.add(next);
                } else if (dist[next] == dist[cur] + 1) {
                    count[next] += count[cur];
                }
            }
        }

        bw.write(String.valueOf(dist[K]));
        bw.newLine();
        bw.write(String.valueOf(count[K]));
        bw.newLine();

        bw.flush();
        br.close();
        bw.close();
    }
}

