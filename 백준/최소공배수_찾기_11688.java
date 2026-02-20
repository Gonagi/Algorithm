import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        br.close();

        if (L % a != 0 || L % b != 0) {
            System.out.print(-1);
            return;
        }
        long abLcm = a * b / gcd(a, b);
        List<Long> divisors = new ArrayList<>();
        for (long i = 1; i * i <= L; i++) {
            if (L % i == 0) {
                divisors.add(i);
                if (i != L / i) {
                    divisors.add(L / i);
                }
            }
        }
        Collections.sort(divisors);

        for (long c : divisors) {
            if (abLcm * c / gcd(abLcm, c) == L) {
                System.out.println(c);
                return;
            }
        }
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

