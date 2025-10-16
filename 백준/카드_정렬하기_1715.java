import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> que = new PriorityQueue<>();
        for (int idx = 0; idx < N; idx++) {
            que.add(Long.parseLong(br.readLine()));
        }

        if (N == 1) {
            bw.write("0\n");
        } else {

            long sum = 0;
            while (que.size() != 1) {
                long num1 = que.poll();
                long num2 = que.poll();
                sum += num1 + num2;
                que.add(num1 + num2);
            }

            bw.write(sum + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

