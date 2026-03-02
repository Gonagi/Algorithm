import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            A[idx] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = N - 1;

        int min = Integer.MAX_VALUE;
        int result = -1;

        while (left < right) {
            int sum = A[left] + A[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                result = sum;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result);

        br.close();
    }
}

