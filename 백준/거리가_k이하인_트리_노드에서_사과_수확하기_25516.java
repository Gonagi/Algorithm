import java.io.*;
import java.util.*;

public class Main {
    static int n, k, result;
    static boolean[] haveApple;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int idx = 0; idx < n; idx++) {
            graph[idx] = new ArrayList<>();
        }

        haveApple = new boolean[n];

        for (int idx = 0; idx < n - 1; idx++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[p].add(c);
        }

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            String a = st.nextToken();
            if (a.equals("1")) {
                haveApple[idx] = true;
            }
        }

        dfs(0, 0);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int cur, int distance) {
        if (haveApple[cur]) {
            result++;
        }

        if (distance == k) {
            return;
        }

        for (int next : graph[cur]) {
            dfs(next, distance + 1);
        }
    }
}

