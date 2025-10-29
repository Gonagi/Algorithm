import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        int result1 = 0, result2 = 0, min = Integer.MAX_VALUE;
        int left = 0, right = N - 1;

        while (left < right) {
            int sum = input[left] + input[right];
            int absSum = Math.abs(sum);

            if (absSum < min) {
                min = absSum;
                result1 = input[left];
                result2 = input[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        bw.write(result1 + " " + result2);

        bw.flush();
        br.close();
        bw.close();
    }
}

