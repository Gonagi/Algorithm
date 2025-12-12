import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node1 implements Comparable<Node1> {
        int idx;
        long num;

        public Node1(int idx, long num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Node1 o) {
            return Long.compare(this.num, o.num);
        }
    }

    static class Node2 implements Comparable<Node2> {
        int idx;
        long num;

        public Node2(int idx, long num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Node2 o) {
            return Long.compare(o.num, this.num);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Node1> minQue = new PriorityQueue<>();
            PriorityQueue<Node2> maxQue = new PriorityQueue<>();
            boolean[] visited = new boolean[k];
            int idx = 0;

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                long num = Long.parseLong(st.nextToken());
                if (input.equals("I")) {
                    minQue.add(new Node1(idx, num));
                    maxQue.add(new Node2(idx, num));
                    visited[idx++] = true;
                } else {
                    if (num == 1) {
                        while (!maxQue.isEmpty() && !visited[maxQue.peek().idx]) {
                            maxQue.poll();
                        }
                        if (!maxQue.isEmpty()) {
                            visited[maxQue.poll().idx] = false;
                        }
                    } else {
                        while (!minQue.isEmpty() && !visited[minQue.peek().idx]) {
                            minQue.poll();
                        }
                        if (!minQue.isEmpty()) {
                            visited[minQue.poll().idx] = false;
                        }
                    }
                }
            }

            while (!minQue.isEmpty() && !visited[minQue.peek().idx]) {
                minQue.poll();
            }
            while (!maxQue.isEmpty() && !visited[maxQue.peek().idx]) {
                maxQue.poll();
            }

            if (minQue.isEmpty() || maxQue.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(String.valueOf(maxQue.poll().num));
                bw.write(" ");
                bw.write(String.valueOf(minQue.poll().num));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

