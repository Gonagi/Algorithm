import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static List<Integer>[] graph;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        people = new int[N + 1];
        graph = new ArrayList[N + 1];
        dp = new int[N + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            people[idx] = Integer.parseInt(st.nextToken());
            graph[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < N - 1; idx++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        dfs(1, 0);

        bw.write(String.valueOf(Math.max(dp[1][0], dp[1][1])));
        bw.flush();
    }

    private static void dfs(int cur, int parent) {
        dp[cur][1] = people[cur];
        dp[cur][0] = 0;

        for (int next : graph[cur]) {
            if (next == parent) {
                continue;
            }
            dfs(next, cur);
            dp[cur][1] += dp[next][0];
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
        }
    }
}

