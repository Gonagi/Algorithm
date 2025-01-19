import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[] visited;
    static boolean check = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int num = 1; num < N; num++) {
            int count = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < count; idx++) {
                matrix[num][Integer.parseInt(st.nextToken())] = 1;
            }
        }

        dfs(1);
        
        if (check) {
            System.out.println("NO CYCLE");
            return;
        }
        System.out.println("CYCLE");
        br.close();
    }

    static void dfs(int cur) {
        if (visited[cur] || !check) {
            check = false;
            return;
        }

        visited[cur] = true;
        for (int num = 1; num <= N; num++) {
            if (matrix[cur][num] == 0) {
                continue;
            }
            dfs(num);
            visited[num] = false;
        }
    }
}
