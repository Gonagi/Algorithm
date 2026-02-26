import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n;
    static int[] pre, in, inIndex;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            n = Integer.parseInt(br.readLine());
            pre = new int[n];
            in = new int[n];
            inIndex = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < n; idx++) {
                pre[idx] = Integer.parseInt(st.nextToken());
                in[idx] = Integer.parseInt(st2.nextToken());
                inIndex[in[idx]] = idx;
            }
            solve(0, n - 1, 0, n - 1);
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    private static void solve(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return;
        }
        int root = pre[preStart];
        int rootIdx = inIndex[root];
        int leftSize = rootIdx - inStart;

        solve(preStart + 1, preStart + leftSize, inStart, rootIdx - 1);
        solve(preStart + leftSize + 1, preEnd, rootIdx + 1, inEnd);
        sb.append(root).append(' ');
    }
}

