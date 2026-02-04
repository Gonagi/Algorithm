import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int idx = 0; idx < N; idx++) {
            numbers[idx] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(numbers);

        int sumSize = N * N;
        int[] sum = new int[sumSize];
        int i = 0;
        for (int idx = 0; idx < N; idx++) {
            for (int idx2 = 0; idx2 < N; idx2++) {
                sum[i++] = numbers[idx] + numbers[idx2];
            }
        }
        Arrays.sort(sum);

        for (int idx = N - 1; idx >= 0; idx--) {
            for (int idx2 = 0; idx2 < N; idx2++) {
                int left = 0;
                int right = sumSize - 1;
                int target = numbers[idx] - numbers[idx2];

                while (left <= right) {
                    int middle = left + (right - left) / 2;
                    if (target < sum[middle]) {
                        right = middle - 1;
                    } else if (target == sum[middle]) {
                        System.out.println(sum[middle] + numbers[idx2]);
                        return;
                    } else {
                        left = middle + 1;
                    }
                }
            }
        }
    }
}

