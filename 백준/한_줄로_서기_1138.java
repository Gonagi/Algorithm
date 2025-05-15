import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int cur = 1; cur <= N; cur++) {
            int higher = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int idx = 0; idx < N; idx++) {
                if (result[idx] == 0 && count >= higher) {
                    result[idx] = cur;
                    break;
                }
                if (result[idx] == 0 || result[idx] > cur) {
                    count++;
                }
            }
        }
        for (int idx = 0; idx < N; idx++) {
            bw.write(result[idx] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

