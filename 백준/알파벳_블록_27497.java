import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();
        Deque<Boolean> stack = new ArrayDeque<>();
        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int button = Integer.parseInt(st.nextToken());
            if (button == 1) {
                deque.addLast(st.nextToken());
                stack.push(true);
            } else if (button == 2) {
                deque.addFirst(st.nextToken());
                stack.push(false);
            } else {
                if (deque.isEmpty()) {
                    continue;
                }
                boolean check = stack.poll();
                if (check) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }

        if (deque.isEmpty()) {
            bw.write("0\n");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str : deque) {
                sb.append(str);
            }
            bw.write(sb.toString());
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

