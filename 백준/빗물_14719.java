import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] height = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < W; idx++) {
            height[idx] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int idx = 1; idx < W - 1; idx++) {
            int left = 0, right = 0;

            for (int idx2 = 0; idx2 < idx; idx2++) {
                left = Math.max(left, height[idx2]);
            }

            for (int idx2 = idx + 1; idx2 < W; idx2++) {
                right = Math.max(right, height[idx2]);
            }

            if (height[idx] < left && height[idx] < right) {
                result += Math.min(left, right) - height[idx];
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

