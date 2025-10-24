import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int idx = 0; idx < N; idx++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[idx] = num;
            sum += num;
            min = Math.min(min, num);
        }

        int start = min;
        int end = sum;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int cal = 0, check = 0;
            for (int idx = 0; idx < N; idx++) {
                cal += numbers[idx];
                if (cal >= mid) {
                    cal = 0;
                    check++;
                }
            }

            if (check < K) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        bw.write(end + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}

