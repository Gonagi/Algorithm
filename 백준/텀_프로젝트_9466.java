import java.io.*;
import java.util.*;

public class Main {
    static int N, result;
    static int[] students;
    static boolean[] visited, check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            N = Integer.parseInt(br.readLine());
            result = 0;
            students = new int[N + 1];
            visited = new boolean[N + 1];
            check = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int idx = 1; idx <= N; idx++) {
                students[idx] = Integer.parseInt(st.nextToken());
            }
            for (int idx = 1; idx <= N; idx++) {
                if (check[idx]) {
                    continue;
                }
                dfs(idx);
            }
            bw.write(N - result + "\n");
            bw.flush();
        }
    }

    public static void dfs(int idx) {
        if (check[idx]) {
            return;
        }
        if (visited[idx]) {
            check[idx] = true;
            result++;
        }

        visited[idx] = true;
        dfs(students[idx]);
        check[idx] = true;
        visited[idx] = false;
    }
}
