import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            S[idx] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, count = 0, result = 0;
        while (right < N) {
            if (S[right] % 2 != 0) {
                count++;
            }
            while (count > K) {
                if (S[left] % 2 != 0) {
                    count--;
                }
                left++;
            }
            result = Math.max(result, (right - left + 1 - count));
            right++;
        }

        System.out.println(result);
        br.close();
    }
}

