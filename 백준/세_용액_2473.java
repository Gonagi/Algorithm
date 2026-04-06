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

        int[] result = new int[3];
        StringBuilder sb = new StringBuilder();

        long min = Long.MAX_VALUE;
        for (int idx = 0; idx < N - 2; idx++) {
            int left = idx + 1, right = N - 1;
            while (left < right) {
                long sum = (long) input[idx] + input[left] + input[right];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    result[0] = input[idx];
                    result[1] = input[left];
                    result[2] = input[right];
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        sb.append(result[0]).append(' ').append(result[1]).append(' ').append(result[2]);
        System.out.println(sb);
        br.close();
    }
}

