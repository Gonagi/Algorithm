import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int won, count;

        public Node(int won, int count) {
            this.won = won;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int testCase = 0; testCase < 3; testCase++) {
            int sum = 0;
            int N = Integer.parseInt(br.readLine());
            Node[] info = new Node[N];

            for (int idx = 0; idx < N; idx++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int won = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                info[idx] = new Node(won, count);
                sum += won * count;
            }

            if (sum % 2 == 1) {
                bw.write("0\n");
            } else {
                sum /= 2;
                boolean[][] dp = new boolean[N + 1][sum + 1];
                dp[0][0] = true;
                for (int i = 1; i <= N; i++) {
                    Node curNode = info[i - 1];
                    for (int j = 0; j <= sum; j++) {
                        if (dp[i - 1][j]) {
                            for (int k = 0; k <= curNode.count; k++) {
                                int tempAmount = j + curNode.won * k;
                                if (tempAmount <= sum) {
                                    dp[i][tempAmount] = true;
                                }
                            }
                        }
                    }
                }
                if (dp[N][sum]) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

