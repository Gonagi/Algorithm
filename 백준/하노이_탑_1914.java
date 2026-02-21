import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 20) {
            hanoi(N, 1, 2, 3);
        }
        BigInteger count = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
        System.out.println(count);
        System.out.println(sb);
        br.close();
    }

    private static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(' ').append(end).append('\n');
            return;
        } else {
            hanoi(n - 1, start, end, mid);
            sb.append(start).append(' ').append(end).append('\n');
            hanoi(n - 1, mid, start, end);
        }
    }
}

