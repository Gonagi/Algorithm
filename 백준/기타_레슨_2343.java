import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lecture = new int[N];

        int left = 0, right = 0;
        for (int idx = 0; idx < N; idx++) {
            lecture[idx] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lecture[idx]);
            right += lecture[idx];
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int count = 1, sum = 0;
            for (int idx = 0; idx < N; idx++) {
                if (sum + lecture[idx] > middle) {
                    count++;
                    sum = 0;
                }
                sum += lecture[idx];
            }

            if (count > M) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println(left);
        br.close();
    }
}

