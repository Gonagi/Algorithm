import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int k, gold, silver, dong;

        public Node(int k, int gold, int silver, int dong) {
            this.k = k;
            this.gold = gold;
            this.silver = silver;
            this.dong = dong;
        }

        @Override
        public int compareTo(Node o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.dong - this.dong;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[N];
        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int dong = Integer.parseInt(st.nextToken());
            nodes[idx] = new Node(k, gold, silver, dong);
        }
        Arrays.sort(nodes);

        int result = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && !(nodes[i].gold == nodes[i - 1].gold &&
                    nodes[i].silver == nodes[i - 1].silver &&
                    nodes[i].dong == nodes[i - 1].dong)) {
                result = i + 1;
            }

            if (nodes[i].k == K) {
                bw.write(result + "\n");
                break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

}

