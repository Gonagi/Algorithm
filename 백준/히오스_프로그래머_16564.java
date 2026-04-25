import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] X = new int[N];
        for (int idx = 0; idx < N; idx++) {
            X[idx] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(X);

        int left = X[0], right = X[N - 1] + K;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            long sum = 0;
            for (int idx = 0; idx < N; idx++) {
                if (middle > X[idx]) {
                    sum += middle - X[idx];
                }
                if (sum > K) {
                    break;
                }
            }

            if (sum > K) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.println(right);
        br.close();
    }
}

