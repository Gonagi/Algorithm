import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int m, v;

        public Node(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.m - o.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node[] jewel = new Node[N];
        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewel[idx] = new Node(M, V);
        }
        Arrays.sort(jewel);

        int[] C = new int[K];
        for (int idx = 0; idx < K; idx++) {
            C[idx] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);

        int idx = 0;
        long sum = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for (int bag : C) {
            while (idx < N && bag >= jewel[idx].m) {
                que.add(jewel[idx].v);
                idx++;
            }

            if (!que.isEmpty()) {
                sum += que.poll();
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}

