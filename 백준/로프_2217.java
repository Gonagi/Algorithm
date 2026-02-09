import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        for (int idx = 0; idx < N; idx++) {
            weight[idx] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weight);

        int max = 0;
        for (int idx = N; idx >= 1; idx--) {
            max = Math.max(max, idx * weight[N - idx]);
        }
        System.out.println(max);
        br.close();
    }
}

