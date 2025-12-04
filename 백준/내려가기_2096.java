import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] maxDP = new int[3];
        int[] minDP = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 0; x < 3; x++) {
            int v = Integer.parseInt(st.nextToken());
            maxDP[x] = v;
            minDP[x] = v;
        }

        for (int y = 1; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            int max0 = maxDP[0], max1 = maxDP[1], max2 = maxDP[2];
            int min0 = minDP[0], min1 = minDP[1], min2 = minDP[2];

            maxDP[0] = Math.max(max0, max1) + num1;
            minDP[0] = Math.min(min0, min1) + num1;

            maxDP[1] = Math.max(Math.max(max0, max1), max2) + num2;
            minDP[1] = Math.min(Math.min(min0, min1), min2) + num2;

            maxDP[2] = Math.max(max1, max2) + num3;
            minDP[2] = Math.min(min1, min2) + num3;
        }

        int max = Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]);
        int min = Math.min(Math.min(minDP[0], minDP[1]), minDP[2]);

        System.out.println(max + " " + min);
    }
}

