import java.io.*;
import java.util.*;

class Main {
    static class Root {
        int start, end, value;

        public Root(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    static int N, D, min = Integer.MAX_VALUE;
    static Root[] roots;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        roots = new Root[N];

        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            roots[idx] = new Root(s, e, l);
        }

        dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int idx = 0; idx <= D; idx++) {
            if (idx > 0) {
                dp[idx] = Math.min(dp[idx], dp[idx - 1] + 1);
            }
            for (Root root : roots) {
                if (root.start == idx && root.end <= D) {
                    dp[root.end] = Math.min(dp[root.end], dp[idx] + root.value);
                }
            }
        }

        bw.write(dp[D] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

