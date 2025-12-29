import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prev = new int[1_000_001];
        int[] next = new int[1_000_001];

        int[] inputs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cur = inputs[i];
            prev[cur] = inputs[(i - 1 + N) % N];
            next[cur] = inputs[(i + 1) % N];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("BN")) {
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                sb.append(next[num1]).append('\n');

                prev[num2] = num1;
                next[num2] = next[num1];
                prev[next[num1]] = num2;
                next[num1] = num2;
            } else if (cmd.equals("BP")) {
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                sb.append(prev[num1]).append('\n');

                next[num2] = num1;
                prev[num2] = prev[num1];
                next[prev[num1]] = num2;
                prev[num1] = num2;
            } else if (cmd.equals("CN")) {
                int num1 = Integer.parseInt(st.nextToken());

                int remove = next[num1];
                sb.append(remove).append('\n');

                next[num1] = next[remove];
                prev[next[remove]] = num1;
            } else {
                int num1 = Integer.parseInt(st.nextToken());

                int remove = prev[num1];
                sb.append(remove).append('\n');

                prev[num1] = prev[remove];
                next[prev[remove]] = num1;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

