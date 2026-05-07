import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] C = new int[N];
        int[] Y = new int[N];
        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            C[idx] = Integer.parseInt(st.nextToken());
            Y[idx] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int idx = 0; idx < N; idx++) {
            int min = C[idx];
            if (idx > 0) {
                min = Math.min(min, C[idx - 1] + S);
                C[idx] = min;
            }
            sum += (long) min * Y[idx];
        }
        System.out.println(sum);
        br.close();
    }
}

