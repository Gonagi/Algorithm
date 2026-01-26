import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> dQue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            int value = Integer.parseInt(st.nextToken());

            while (!dQue.isEmpty() && dQue.peekLast().value > value) {
                dQue.pollLast();
            }

            dQue.add(new Node(value, idx));

            if (dQue.peekFirst().index <= idx - L) {
                dQue.pollFirst();
            }

            sb.append(dQue.peekFirst().value).append(' ');

        }

        System.out.println(sb);
        br.close();
    }
}

