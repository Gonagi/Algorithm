import java.io.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = (long) N * N;
        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            for (int idx = 1; idx <= N; idx++) {
                count += Math.min(mid / idx, N);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}

