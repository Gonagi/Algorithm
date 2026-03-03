import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primeNum = new ArrayList<>();
        for (int num = 0; num <= N; num++) {
            if (isPrime[num]) {
                primeNum.add(num);
            }
        }

        int size = primeNum.size();
        int left = 0, right = 0;
        int sum = 0;
        int result = 0;

        while (true) {
            if (sum >= N) {
                sum -= primeNum.get(left++);
            } else {
                if (right == size) {
                    break;
                }
                sum += primeNum.get(right++);
            }

            if (sum == N) {
                result++;
            }
        }
        System.out.println(result);
        br.close();
    }
}

