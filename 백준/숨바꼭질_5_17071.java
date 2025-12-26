import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 500_001;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = -1;
        boolean[][] visited = new boolean[MAX][2];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(N);
        visited[N][0] = true;

        int time = 0;
        while (!que.isEmpty()) {
            int smallIdx = K + time * (time + 1) / 2;
            if (smallIdx >= MAX) {
                break;
            }

            if (visited[smallIdx][time % 2]) {
                result = time;
                break;
            }

            int size = que.size();
            for (int i = 0; i < size; i++) {
                int cur = que.poll();

                for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                    if (next >= 0 && next < MAX && !visited[next][(time + 1) % 2]) {
                        visited[next][(time + 1) % 2] = true;
                        que.add(next);
                    }
                }
            }
            time++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}

