import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int cmd, value;

        public Node(int cmd, int value) {
            this.cmd = cmd;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Node[] inputs = new Node[Q];
        int lastOneIdx = -1;
        for (int idx = 0; idx < Q; idx++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                int value = Integer.parseInt(st.nextToken());
                inputs[idx] = new Node(cmd, value);
            } else {
                if (cmd == 1) {
                    lastOneIdx = idx;
                }
                inputs[idx] = new Node(cmd, -1);
            }
        }

        Deque<Integer> dQue = new ArrayDeque<>();
        boolean checkReverse = false;
        if (lastOneIdx == -1) {
            for (Node node : inputs) {
                if (node.cmd == 0) {
                    if (!checkReverse) {
                        dQue.addFirst(node.value);
                    } else {
                        dQue.addLast(node.value);
                    }
                } else if (node.cmd == 2) {
                    checkReverse = !checkReverse;
                }
            }
        } else {
            List<Integer> list = new ArrayList<>();
            for (int idx = 0; idx < lastOneIdx; idx++) {
                Node node = inputs[idx];
                if (node.cmd == 0) {
                    list.add(node.value);
                }
            }
            Collections.sort(list);

            dQue = new ArrayDeque<>(list);
            for (int idx = lastOneIdx + 1; idx < Q; idx++) {
                Node node = inputs[idx];
                if (node.cmd == 0) {
                    if (!checkReverse) {
                        dQue.addFirst(node.value);
                    } else {
                        dQue.addLast(node.value);
                    }
                } else if (node.cmd == 2) {
                    checkReverse = !checkReverse;
                }
            }
        }

        for (int idx = 0; idx < k - 1; idx++) {
            if (!checkReverse) {
                dQue.pollFirst();
            } else {
                dQue.pollLast();
            }
        }

        System.out.println(!checkReverse ? dQue.pollFirst() : dQue.pollLast());
        br.close();
    }
}

