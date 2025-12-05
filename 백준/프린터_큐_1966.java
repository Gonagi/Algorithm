import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx, value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<Node> que = new ArrayDeque<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

            for (int idx = 0; idx < N; idx++) {
                int value = Integer.parseInt(st.nextToken());
                que.addLast(new Node(idx, value));
                maxPQ.add(value);
            }

            int count = 0;

            while (true) {
                Node cur = que.pollFirst();

                int top = maxPQ.peek();

                if (cur.value == top) {
                    count++;
                    maxPQ.poll();

                    if (cur.idx == M) {
                        break;
                    }

                } else {
                    que.addLast(cur);
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

