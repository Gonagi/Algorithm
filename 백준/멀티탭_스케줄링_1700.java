import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[K];
        Queue<Integer>[] que = new ArrayDeque[K + 1];
        for (int idx = 1; idx <= K; idx++) {
            que[idx] = new ArrayDeque<>();
        }

        for (int idx = 0; idx < K; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
            que[input[idx]].add(idx);
        }

        int[] outlet = new int[N];
        Arrays.fill(outlet, -1);

        int result = 0;
        for (int idx = 0; idx < K; idx++) {
            que[input[idx]].poll();
            boolean check = false;
            for (int idx2 = 0; idx2 < N; idx2++) {
                if (outlet[idx2] == input[idx]) {
                    check = true;
                    break;
                }
            }

            if (check) {
                continue;
            }

            for (int idx2 = 0; idx2 < N; idx2++) {
                if (outlet[idx2] == -1) {
                    outlet[idx2] = input[idx];
                    check = true;
                    break;
                }
            }

            if (check) {
                continue;
            }

            int maxIdx = -1, max = -1;
            for (int idx2 = 0; idx2 < N; idx2++) {
                int cur = outlet[idx2];
                if (que[cur].isEmpty()) {
                    maxIdx = idx2;
                    break;
                }
                if (max < que[cur].peek()) {
                    max = que[cur].peek();
                    maxIdx = idx2;
                }
            }

            outlet[maxIdx] = input[idx];
            result++;
        }
        System.out.println(result);
        br.close();
    }
}

