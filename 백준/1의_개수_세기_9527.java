import java.io.*;
import java.util.*;

public class Main {
    static long[] dp = new long[55];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        bw.write(count(B) - count(A - 1) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static long count(long a) {
        if (a == 0 || a == 1)
            return a;
        int digits = 0;
        long powOf2 = 1;
        while (powOf2 * 2 <= a) {
            powOf2 *= 2;
            digits++;
        }
        return digits * powOf2 / 2 + (a - powOf2 + 1) + count(a - powOf2);
    }
}

