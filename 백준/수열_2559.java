import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int idx = 0; idx < K; idx++) {
            sum += input[idx];
        }
        int max = sum;
        for (int idx = K; idx < N; idx++) {
            sum += input[idx];
            sum -= input[idx - K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
        br.close();
    }
}

