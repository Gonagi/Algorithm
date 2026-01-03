import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Deque<Integer> backDeque = new ArrayDeque<>();
        Deque<Integer> frontDeque = new ArrayDeque<>();
        int cur = -1;
        for (int idx = 0; idx < Q; idx++) {
            String input = br.readLine();
            if (input.equals("B")) {
                if (!backDeque.isEmpty()) {
                    frontDeque.addFirst(cur);
                    cur = backDeque.pollLast();
                }
            } else if (input.equals("F")) {
                if (!frontDeque.isEmpty()) {
                    backDeque.addLast(cur);
                    cur = frontDeque.pollFirst();
                }
            } else if (input.equals("C")) {
                if (backDeque.isEmpty()) {
                    continue;
                }
                Deque<Integer> newDeque = new ArrayDeque<>();
                while (!backDeque.isEmpty()) {
                    int num1 = backDeque.pollLast();
                    if (!newDeque.isEmpty()) {
                        int num2 = newDeque.peekFirst();
                        if (num1 != num2) {
                            newDeque.addFirst(num1);
                        }
                    } else {
                        newDeque.addFirst(num1);
                    }
                }
                backDeque = newDeque;
            } else {
                st = new StringTokenizer(input);
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                frontDeque.clear();
                if (cur != -1) {
                    backDeque.addLast(cur);
                }
                cur = num;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cur).append('\n');
        if (backDeque.isEmpty()) {
            sb.append("-1");
        } else {
            while (!backDeque.isEmpty()) {
                sb.append(backDeque.pollLast()).append(' ');
            }
        }
        sb.append('\n');
        if (frontDeque.isEmpty()) {
            sb.append("-1");
        } else {
            while (!frontDeque.isEmpty()) {
                sb.append(frontDeque.pollFirst()).append(' ');
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

