import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;

        for (int idx = 0; idx < n; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast() > y) {
                deque.pollLast();
                count++;
            }

            if (deque.isEmpty() || deque.peekLast() < y) {
                if (y > 0) {
                    deque.addLast(y);
                }
            }

        }

        count += deque.size();

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

