import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger[] catalan = new BigInteger[31];
        catalan[0] = BigInteger.ONE;

        for (int n = 1; n <= 30; n++) {
            catalan[n] = BigInteger.ZERO;
            for (int i = 0; i < n; i++) {
                catalan[n] = catalan[n].add(catalan[i].multiply(catalan[n - 1 - i]));
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            bw.write(catalan[N].toString());
            bw.newLine();
        }

        bw.flush();
    }
}

