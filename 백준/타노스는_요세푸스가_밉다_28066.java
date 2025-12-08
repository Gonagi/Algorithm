import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int idx = 1; idx <= N; idx++) {
            deque.add(idx);
        }

        while (deque.size() != 1) {
            int curSize = deque.size();
            deque.addLast(deque.pollFirst());

            if (K < curSize) {
                for (int idx = 0; idx < K - 1; idx++) {
                    deque.pollFirst();
                }
            } else {
                for (int idx = 0; idx < curSize - 1; idx++) {
                    deque.pollFirst();
                }
            }
        }

        bw.write(String.valueOf(deque.pollFirst()));
        bw.flush();
        bw.close();
        br.close();
    }
}

