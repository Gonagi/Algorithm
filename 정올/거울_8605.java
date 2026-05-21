import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long[] mirror = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            mirror[idx] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(mirror);

        long minusSum = 0;
        long plusSum = 0;

        int minusCount = N / 2;
        for (int idx = 0; idx < minusCount; idx++) {
            minusSum += mirror[idx];
        }

        for (int idx = minusCount; idx < N; idx++) {
            plusSum += mirror[idx];
        }

        long answer;
        if (N % 2 == 0) {
            answer = s + 2 * (plusSum - minusSum);
        } else {
            answer = -s + 2 * (plusSum - minusSum);
        }

        System.out.println(answer);
        br.close();
    }
}

