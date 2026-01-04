import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            P[idx] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        long answer = 0;
        for (int idx = 1; idx <= N; idx++) {
            int cur = P[idx];

            while (!stack.isEmpty() && stack.peek() < cur) {
                stack.poll();
                answer++;
            }

            if (!stack.isEmpty()) {
                answer++;
            }

            stack.push(cur);
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}

