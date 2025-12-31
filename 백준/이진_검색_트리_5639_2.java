import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            Node curNode = new Node(num);
            Node parent = null;

            while (!stack.isEmpty() && stack.peek().value < num) {
                parent = stack.pop();
            }

            if (parent != null) {
                parent.right = curNode;
            } else {
                stack.peek().left = curNode;
            }

            stack.push(curNode);
        }

        postorder(root);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value).append('\n');
    }
}

