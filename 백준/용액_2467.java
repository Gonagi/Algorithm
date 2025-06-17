import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            solution[idx] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int result1 = 0, result2 = 0;
        long resultSum = Long.MAX_VALUE;

        while (left < right) {
            long sum = solution[left] + solution[right];

            if (Math.abs(sum) < resultSum) {
                resultSum = Math.abs(sum);
                result1 = solution[left];
                result2 = solution[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(result1 + " " + result2);
        bw.flush();
        br.close();
        bw.close();
    }
}

