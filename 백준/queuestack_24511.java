import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            inputs[idx] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> que = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            int num = Integer.parseInt(st.nextToken());
            if (inputs[idx] == 0) {
                que.addFirst(num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < M; idx++) {
            int num = Integer.parseInt(st.nextToken());
            if (que.isEmpty()) {
                sb.append(num).append(' ');
            } else {
                sb.append(que.poll()).append(' ');
                que.add(num);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

