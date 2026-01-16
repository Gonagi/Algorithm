import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char value;
        Node prev, next;

        Node(char value) {
            this.value = value;
        }

        Node() {
        }
    }

    static class LinkedList {
        Node head = new Node();
        Node tail = new Node();
        Node rthNode = head;
        int r = 0, size = 0;

        LinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        void insert(Node prev, Node node) {
            Node next = prev.next;
            prev.next = node;
            node.prev = prev;
            node.next = next;
            next.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        void add(char c) {
            insert(tail.prev, new Node(c));
        }

        void moveLeft() {
            if (size <= 1) {
                return;
            }

            rthNode = (r == size) ? head.next : rthNode.next;

            Node first = head.next;
            remove(first);
            insert(tail.prev, first);
        }

        void moveRight() {
            rthNode = (r == 1) ? tail.prev : rthNode.prev;

            Node last = tail.prev;
            remove(last);
            insert(head, last);
        }

        void setRthNode(int target) {
            while (r < target) {
                r++;
                rthNode = rthNode.next;
            }
            while (r > target) {
                r--;
                rthNode = rthNode.prev;
            }
        }

        void exchange(LinkedList other, int R) {
            setRthNode(R);
            other.setRthNode(R);

            Node a1 = head.next;
            Node aR = rthNode;
            Node aN = aR.next;

            Node b1 = other.head.next;
            Node bR = other.rthNode;
            Node bN = bR.next;

            head.next = b1;
            b1.prev = head;

            bR.next = aN;
            aN.prev = bR;

            other.head.next = a1;
            a1.prev = other.head;

            aR.next = bN;
            bN.prev = aR;

            Node tmp = rthNode;
            rthNode = other.rthNode;
            other.rthNode = tmp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        String s1 = br.readLine();
        String s2 = br.readLine();

        for (int idx = 0; idx < N; idx++) {
            list1.add(s1.charAt(idx));
            list2.add(s2.charAt(idx));
        }

        list1.setRthNode(R);
        list2.setRthNode(R);

        int curR = R;

        for (int i = 0; i < Q; i++) {
            String line = br.readLine();
            if (line.equals("S")) {
                list1.exchange(list2, curR);
            } else if (line.equals("I")) {
                curR++;
            } else if (line.equals("D")) {
                curR--;
            } else {
                st = new StringTokenizer(line);
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                LinkedList target = (x == 1) ? list1 : list2;

                if (cmd.equals("L")) {
                    target.moveLeft();
                } else {
                    target.moveRight();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Node cur = list1.head.next;
        while (cur != list1.tail) {
            sb.append(cur.value);
            cur = cur.next;
        }
        sb.append('\n');

        cur = list2.head.next;
        while (cur != list2.tail) {
            sb.append(cur.value);
            cur = cur.next;
        }

        System.out.println(sb.toString());
        br.close();
    }
}

