import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] biggerList;
    private static List<Integer>[] smallerList;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        biggerList = new ArrayList[N + 1];
        smallerList = new ArrayList[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            biggerList[idx] = new ArrayList<>();
            smallerList[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < M; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            biggerList[node2].add(node1);
            smallerList[node1].add(node2);
        }

        for (int cur = 1; cur <= N; cur++) {
            visited = new boolean[N + 1];
            dfs(cur, biggerList);
            dfs(cur, smallerList);
            int count = 0;
            for (int idx = 1; idx <= N; idx++) {
                if (!visited[idx]) {
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int cur, List<Integer>[] list) {
        visited[cur] = true;
        if (!list[cur].isEmpty()) {
            for (int next : list[cur]) {
                if (!visited[next]) {
                    dfs(next, list);
                }
            }
        }
    }
}

