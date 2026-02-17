import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] L = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            L[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(L);

        int left = 1, right = L[N];
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int total = 0;
            for (int idx = 1; idx <= N; idx++) {
                total += L[idx] / mid;
            }

            if (total >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
        br.close();
    }
}

