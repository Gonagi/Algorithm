import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N];
        int[] price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int idx = 0; idx < N; idx++) {
            if (idx < N - 1) {
                distance[idx] = Integer.parseInt(st.nextToken());
            }
            price[idx] = Integer.parseInt(st2.nextToken());
        }

        long total = 0;
        int minPrice = price[0];

        for (int idx = 0; idx < N - 1; idx++) {
            total += (long) distance[idx] * minPrice;
            if (minPrice > price[idx + 1]) {
                minPrice = price[idx + 1];
            }
        }

        bw.write(total + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

