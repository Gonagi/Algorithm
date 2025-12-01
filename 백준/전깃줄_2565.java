import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int from, to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
            if (this.from != o.from) {
                return Integer.compare(this.from, o.from);
            }
            return Integer.compare(this.to, o.to);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Node> list = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < count; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.add(new Node(from, to));
        }
        Collections.sort(list);

        int max = 0;
        int[] dp = new int[count];
        for (int idx = 0; idx < count; idx++) {
            dp[idx] = 1;
            int cur = list.get(idx).to;
            for (int idx2 = 0; idx2 < idx; idx2++) {
                int prev = list.get(idx2).to;
                if (prev < cur) {
                    dp[idx] = Math.max(dp[idx], dp[idx2] + 1);
                }
            }
            max = Math.max(max, dp[idx]);
        }

        bw.write(String.valueOf(count - max));

        bw.flush();
        br.close();
        bw.close();
    }
}

