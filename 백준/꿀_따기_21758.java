import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] prefix = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
        }

        prefix[0] = input[0];
        for (int idx = 1; idx < N; idx++) {
            prefix[idx] = prefix[idx - 1] + input[idx];
        }

        int max = 0;
        for (int idx = 1; idx < N - 1; idx++) {
            int cur = (prefix[N - 1] - input[0] - input[idx]) + (prefix[N - 1] - prefix[idx]);
            max = Math.max(max, cur);
        }
        for (int idx = 1; idx < N - 1; idx++) {
            int cur = (prefix[idx] - prefix[0]) + (prefix[N - 2] - prefix[idx - 1]);
            max = Math.max(max, cur);
        }
        for (int idx = 1; idx < N - 1; idx++) {
            int cur = (prefix[N - 2] - input[idx]) + prefix[idx - 1];
            max = Math.max(max, cur);
        }
        System.out.println(max);
        br.close();
    }
}

