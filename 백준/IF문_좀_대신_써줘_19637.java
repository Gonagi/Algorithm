import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] title = new String[N];
        int[] power = new int[N];

        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            title[idx] = st.nextToken();
            power[idx] = Integer.parseInt(st.nextToken());
        }

        for (int idx = 0; idx < M; idx++) {
            int input = Integer.parseInt(br.readLine());
            int left = 0, right = N - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midValue = power[mid];
                if (input <= midValue) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            bw.write(title[left] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

