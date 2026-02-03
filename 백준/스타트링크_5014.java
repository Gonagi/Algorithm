import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[] visited = new int[F + 1];
        Arrays.fill(visited, -1);
        Queue<Integer> que = new ArrayDeque<>();
        que.add(S);
        visited[S] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == G) {
                System.out.println(visited[cur]);
                return;
            }
            int nextUp = cur + U;
            if (canMove(nextUp) && visited[nextUp] == -1) {
                visited[nextUp] = visited[cur] + 1;
                que.add(nextUp);
            }
            int nextDown = cur - D;
            if (canMove(nextDown) && visited[nextDown] == -1) {
                visited[nextDown] = visited[cur] + 1;
                que.add(nextDown);
            }
        }

        System.out.println("use the stairs");
        br.close();
    }

    private static boolean canMove(int cur) {
        return cur >= 1 && cur <= F;
    }
}

