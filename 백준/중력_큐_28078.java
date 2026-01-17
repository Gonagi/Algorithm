import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        ArrayDeque<Character> deque = new ArrayDeque<>();
        int dir = 0, bCount = 0, wCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < Q; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input1 = st.nextToken();
            String input2 = "";
            if (input1.equals("push")) {
                input2 = st.nextToken();
                if (input2.equals("b")) {
                    if (dir == 0 || dir == 2) {
                        deque.offer('b');
                        bCount++;
                    } else if (dir == 1) {
                        if (!deque.isEmpty()) {
                            deque.offer('b');
                            bCount++;
                        }
                    }
                } else {
                    deque.offer('w');
                    wCount++;
                }
            } else if (input1.equals("pop")) {
                if (deque.isEmpty()) {
                    continue;
                }
                char ch = deque.poll();
                if (ch == 'b') {
                    bCount--;
                } else {
                    wCount--;
                }

                if (dir == 1) {
                    while (!deque.isEmpty() && deque.peekFirst() != 'w') {
                        deque.pollFirst();
                        bCount--;
                    }
                }
            } else if (input1.equals("rotate")) {
                input2 = st.nextToken();
                if (input2.equals("l")) {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }

                if (dir == 1) {
                    while (!deque.isEmpty() && deque.peekFirst() != 'w') {
                        deque.pollFirst();
                        bCount--;
                    }
                } else if (dir == 3) {
                    while (!deque.isEmpty() && deque.peekLast() != 'w') {
                        deque.pollLast();
                        bCount--;
                    }
                }
            } else if (input1.equals("count")) {
                input2 = st.nextToken();
                if (input2.equals("b")) {
                    sb.append(bCount).append('\n');
                } else {
                    sb.append(wCount).append('\n');
                }
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}

