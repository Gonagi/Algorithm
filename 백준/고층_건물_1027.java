import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] buildings;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        buildings = new int[N];
        for (int idx = 0; idx < N; idx++) {
            buildings[idx] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int idx = 0; idx < N; idx++) {
            max = Math.max(max, cal(idx));
        }

        bw.write(max + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int cal(int cur) {
        int count = 0;
        double d = 0;

        for (int idx = cur - 1; idx >= 0; idx--) {
            double slope = (double) (buildings[cur] - buildings[idx]) / (cur - idx);

            if (idx == cur - 1 || d > slope) {
                count++;
                d = slope;
            }
        }

        for (int idx = cur + 1; idx < N; idx++) {
            double slope = (double) (buildings[idx] - buildings[cur]) / (idx - cur);

            if (idx == cur + 1 || d < slope) {
                count++;
                d = slope;
            }
        }

        return count;
    }
}

