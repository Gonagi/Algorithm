import java.io.*;
import java.util.*;

public class Main {
    static int[] houses;
    static int N, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int idx = 0; idx < N; idx++) {
            houses[idx] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 1, right = houses[N - 1] - houses[0], result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int prev = houses[0];
            int count = 1;

            for (int idx = 1; idx < N; idx++) {
                if (houses[idx] - prev >= mid) {
                    prev = houses[idx];
                    count++;
                }
            }

            if (count < C) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}

