import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] S = new long[n + 1];
        int[] M = new int[n + 1];
        int[] C = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= n; idx++) {
            int num = Integer.parseInt(st.nextToken());
            S[idx] = S[idx - 1] + num;
            M[idx] = (int) (S[idx] % m);
            C[M[idx]]++;
        }

        long sum = C[0];
        for (int i = 0; i < m; i++) {
            long count = C[i];
            if (count < 2) {
                continue;
            }
            sum += (count * (count - 1)) / 2;
        }

        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

