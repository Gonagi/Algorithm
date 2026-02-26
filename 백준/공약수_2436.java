import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long cur = B / A;
        long min = Long.MAX_VALUE;
        long minA = -1, minB = -1;

        for (int num = 1; num * num <= cur; num++) {
            if (cur % num == 0) {
                long a = num;
                long b = cur / num;
                if (gcd(a, b) == 1) {
                    if (min > a + b) {
                        min = a + b;
                        minA = a;
                        minB = b;
                    }
                }
            }
        }
        sb.append(minA * A).append(' ').append(minB * A);
        System.out.println(sb);
        br.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

