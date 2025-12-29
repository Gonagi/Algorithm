import java.io.*;

public class Main {
    static class Node {
        int parent, left, right;

        public Node(int parent, int left, int right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    static int MAX = 1_000_001;
    static Node[] nodes;
    static int[] inputs;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        nodes = new Node[MAX];
        inputs = new int[MAX];

        int idx = 0, prevNum = 0;
        String input = "";
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            inputs[idx] = num;
            if (idx == 0) {
                nodes[num] = new Node(0, 0, 0);
            } else if (prevNum > num) {
                Node prevNode = nodes[prevNum];
                prevNode.left = num;
                nodes[num] = new Node(prevNum, 0, 0);
            } else {
                int idx2 = idx;
                for (; idx2 >= 0; idx2--) {
                    if (inputs[idx2] > num) {
                        break;
                    }
                }
                int parentValue = inputs[idx2 + 1];
                Node parentNode = nodes[parentValue];

                while (parentNode.right != 0) {
                    parentValue = parentNode.right;
                    parentNode = nodes[parentValue];

                    if (num < parentValue) {
                        break;
                    }
                }

                if (num < parentValue && parentNode.left == 0) {
                    parentNode.left = num;
                } else {
                    parentNode.right = num;
                }

                nodes[num] = new Node(parentValue, 0, 0);
            }
            prevNum = num;
            idx++;
        }

        dfs(inputs[0]);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int curNum) {
        Node curNode = nodes[curNum];
        if (curNode.left != 0) {
            dfs(curNode.left);
        }
        if (curNode.right != 0) {
            dfs(curNode.right);
        }
        sb.append(curNum).append('\n');
    }
}

