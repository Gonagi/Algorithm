import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Deque<Integer> deque[] = new ArrayDeque[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            deque[idx] = new ArrayDeque<>();
        }

        int count = 0;
        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            while (!deque[num1].isEmpty() && deque[num1].peekLast() > num2) {
                deque[num1].pollLast();
                count++;
            }

            if (deque[num1].isEmpty() || deque[num1].peekLast() < num2) {
                deque[num1].addLast(num2);
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
}

