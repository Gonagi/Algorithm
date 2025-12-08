import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int score, time;

        public Node(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();
        int result = 0;
        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("0")) {
                if (!stack.isEmpty()) {
                    Node curNode = stack.pop();
                    if (curNode.time == 1) {
                        result += curNode.score;
                    } else {
                        stack.add(new Node(curNode.score, curNode.time - 1));
                    }
                }
                continue;
            } else {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                if (time == 1) {
                    result += score;
                } else {
                    stack.add(new Node(score, time - 1));
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}

