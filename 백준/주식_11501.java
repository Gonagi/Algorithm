import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] numbers = new int[N];
            for (int idx = 0; idx < N; idx++) {
                numbers[idx] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int cur = numbers[N - 1];
            for (int idx = N - 1; idx >= 0; idx--) {
                if (cur < numbers[idx]) {
                    cur = numbers[idx];
                } else {
                    sum += cur - numbers[idx];
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

