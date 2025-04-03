import java.io.*;
import java.util.*;

class Main {
    static int N, d, k, c;
    static int[] sushis, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushis = new int[N];
        count = new int[d + 1];

        int kinds = 0;
        for (int idx = 0; idx < N; idx++) {
            sushis[idx] = Integer.parseInt(br.readLine());
            if (idx < k) {
                if (count[sushis[idx]] == 0) {
                    kinds++;
                }
                count[sushis[idx]]++;
            }
        }

        int max = kinds;
        if (count[c] == 0) {
            max++;
        }

        for (int idx = 1; idx < N; idx++) {
            int remove = sushis[idx - 1];
            count[remove]--;
            if (count[remove] == 0) {
                kinds--;
            }

            int add = sushis[(idx + k - 1) % N];
            if (count[add] == 0) {
                kinds++;
            }
            count[add]++;

            int temp = kinds;
            if (count[c] == 0) {
                temp++;
            }
            max = Math.max(max, temp);
        }

        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

