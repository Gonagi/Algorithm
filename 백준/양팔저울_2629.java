import java.io.*;
import java.util.*;

public class Main {
    static int weightCount, marbleCount;
    static int[] weights;
    static boolean[][] visited;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        weightCount = Integer.parseInt(br.readLine());
        weights = new int[weightCount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < weightCount; idx++) {
            weights[idx] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[weightCount + 1][40_001];
        check = new boolean[40_001];

        dfs(0, 0);

        marbleCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < marbleCount; idx++) {
            int marble = Integer.parseInt(st.nextToken());
            sb.append(check[marble] ? "Y " : "N ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int idx, int curWeight) {
        if (visited[idx][curWeight])
            return;

        visited[idx][curWeight] = true;
        check[curWeight] = true;

        if (idx == weightCount) {
            return;
        }

        dfs(idx + 1, curWeight);
        if (curWeight + weights[idx] <= 40_000) {
            dfs(idx + 1, curWeight + weights[idx]);
        }
        dfs(idx + 1, Math.abs(curWeight - weights[idx]));
    }
}

