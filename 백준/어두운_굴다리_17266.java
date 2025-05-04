import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] lights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lights = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < M; idx++) {
            lights[idx] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean possible(int height) {
        int prev = 0;
        for (int idx = 0; idx < M; idx++) {
            if (lights[idx] - height <= prev) {
                prev = lights[idx] + height;
            } else {
                return false;
            }
        }

        return N <= prev;
    }
}

