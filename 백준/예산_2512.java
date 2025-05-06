import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] prices;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        prices = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0, max = 0;
        for (int idx = 0; idx < N; idx++) {
            prices[idx] = Integer.parseInt(st.nextToken());
            sum += prices[idx];
            max = Math.max(max, prices[idx]);
        }

        M = Integer.parseInt(br.readLine());
        if (sum <= M) {
            bw.write(max + "\n");
        } else {
            int left = 1;
            int right = max;

            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (check(mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            bw.write((left - 1) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean check(int mid) {
        int sum = 0;
        for (int idx = 0; idx < N; idx++) {
            if (prices[idx] <= mid) {
                sum += prices[idx];
            } else {
                sum += mid;
            }
        }
        return sum <= M;
    }
}

