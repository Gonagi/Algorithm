import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long cur, idx;

        public Node(long cur, long idx) {
            this.cur = cur;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        for (int idx = 1; idx <= N; idx++) {
            long num = Long.parseLong(st.nextToken());
            deque.add(new Node(num, idx));
        }

        while (deque.size() > 1) {
            Deque<Node> deque2 = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                Node curNode = deque.poll();

                if (deque2.isEmpty()) {
                    if (deque.isEmpty()) {
                        continue;
                    }
                    if (deque.peekFirst().cur <= curNode.cur) {
                        Node nextNode = deque.pollFirst();
                        curNode.cur += nextNode.cur;
                    }
                    deque2.add(curNode);
                } else {
                    if (deque.isEmpty()) {
                        if (deque2.peekLast().cur <= curNode.cur) {
                            Node prevNode = deque2.pollLast();
                            curNode.cur += prevNode.cur;
                        }
                        deque2.add(curNode);
                    } else {
                        long middle = curNode.cur;
                        if (middle >= deque2.peekLast().cur) {
                            if (middle >= deque.peekFirst().cur) {
                                Node prevNode = deque2.pollLast();
                                Node nextNode = deque.pollFirst();
                                curNode.cur += prevNode.cur;
                                curNode.cur += nextNode.cur;
                            } else {
                                Node prevNode = deque2.pollLast();
                                curNode.cur += prevNode.cur;
                            }
                            deque2.add(curNode);
                        } else {
                            if (middle >= deque.peekFirst().cur) {
                                Node nextNode = deque.pollFirst();
                                curNode.cur += nextNode.cur;
                            }
                            deque2.add(curNode);
                        }
                    }
                }
            }

            deque = deque2;
        }

        Node node = deque.poll();
        StringBuilder sb = new StringBuilder();
        sb.append(node.cur).append('\n').append(node.idx);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

