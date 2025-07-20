import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Deque<Integer> result = new ArrayDeque<>();

        if (a + b > N + 1) {
            bw.write(-1 + "\n");
        } else {
            for (int idx = 1; idx < a; idx++) {
                result.add(idx);
            }
            result.add(Math.max(a, b));

            for (int idx = b - 1; idx >= 1; idx--) {
                result.add(idx);
            }

            int first = result.pollFirst();
            int qSize = result.size();
            for (int idx = 1; idx < N - qSize; idx++) {
                result.addFirst(1);
            }
            result.addFirst(first);

            for (int idx = 0; idx < N; idx++) {
                bw.write(result.pollFirst() + " ");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

