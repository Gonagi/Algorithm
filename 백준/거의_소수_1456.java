import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        boolean[] isNotPrime = new boolean[10_000_001];
        for (int num = 2; num * num < 10_000_001; num++) {
            if (isNotPrime[num]) {
                continue;
            }

            for (int next = num * num; next < 10_000_001; next += num) {
                isNotPrime[next] = true;
            }
        }

        int count = 0;
        for (int num = 2; num < 10_000_001; num++) {
            if (!isNotPrime[num]) {
                long curNum = (long) num * num;
                while (curNum <= B) {
                    if (A <= curNum) {
                        count++;
                    }
                    if (curNum > B / num) {
                        break;
                    }
                    curNum *= num;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}

