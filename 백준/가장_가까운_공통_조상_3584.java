import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check;
    static int[] parent;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            Arrays.fill(parent, -1);

            for (int idx = 0; idx < N - 1; idx++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                parent[B] = A;
            }

            check = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            dfs(num1);
            bw.write(String.valueOf(find(num2)));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int find(int num2) {
        if (check[num2]) {
            return num2;
        }

        return find(parent[num2]);
    }

    private static void dfs(int num1) {
        if (num1 == -1) {
            return;
        }

        check[num1] = true;
        dfs(parent[num1]);
    }
}

