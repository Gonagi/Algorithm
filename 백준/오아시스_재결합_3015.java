import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int height;
        long count;

        public Node(int height, long count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Node> stack = new ArrayDeque<>();
        long answer = 0;

        for (int idx = 0; idx < N; idx++) {
            int curHeight = Integer.parseInt(br.readLine());
            long curCount = 1;

            while (!stack.isEmpty() && stack.peek().height < curHeight) {
                answer += stack.peek().count;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek().height == curHeight) {
                Node leftNode = stack.pop();
                answer += leftNode.count;
                curCount += leftNode.count;
            }

            if (!stack.isEmpty()) {
                answer++;
            }

            stack.push(new Node(curHeight, curCount));
        }

        System.out.println(answer);
    }
}

