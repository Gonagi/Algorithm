import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        int M = Integer.parseInt(br.readLine());

        int size = input.length;
        int left = 0, right = input[size - 1], result = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            long sum = 0;
            for (int idx = 0; idx < size; idx++) {
                sum += (long)Math.min(input[idx], middle);
            }

            if (sum <= M) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(result);
        br.close();
    }
}

