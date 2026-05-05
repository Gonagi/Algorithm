import java.io.*;
import java.util.*;

public class Main {
    static int N, max = 0;
    static int[] input, sumArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        sumArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
            sumArr[idx] = input[idx];
            if (idx > 0) {
                sumArr[idx] += sumArr[idx - 1];
            }
        }

        for (int idx = 1; idx < N - 1; idx++) {
            int sum1 = sumArr[N - 1] - input[0] - input[idx] + sumArr[N - 1] - sumArr[idx];
            int sum2 = sumArr[idx] - input[0] + sumArr[N - 2] - sumArr[idx - 1];
            int sum3 = sumArr[N - 2] - input[idx] + sumArr[idx - 1];
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
            max = Math.max(max, sum3);
        }

        System.out.println(max);
        br.close();
    }
}

