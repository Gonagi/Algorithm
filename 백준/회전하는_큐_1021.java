import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int idx = 1; idx <= N; idx++) {
            deque.addLast(idx);
        }

        int[] inputs = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < M; idx++) {
            inputs[idx] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int idx = 0; idx < M; idx++) {
            int cur = inputs[idx];

            if (cur != deque.peekFirst()) {
                int curIdx = 0;
                for (int num : deque) {
                    if (num == cur) {
                        break;
                    }
                    curIdx++;
                }
                int curSize = deque.size();
                if (curIdx < curSize - curIdx) {
                    for (int idx2 = 0; idx2 < curIdx; idx2++) {
                        int num = deque.pollFirst();
                        deque.addLast(num);
                        result++;
                    }
                } else {
                    for (int idx2 = 0; idx2 < curSize - curIdx; idx2++) {
                        int num = deque.pollLast();
                        deque.addFirst(num);
                        result++;
                    }
                }
            }
            deque.pollFirst();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}

