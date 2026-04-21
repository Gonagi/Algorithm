import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int idx = 0; idx < N; idx++) {
            numbers[idx] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        int value = numbers[N - 1] - numbers[N - 2];
        for (int idx = N - 2; idx >= 1; idx--) {
            value = gcd(value, numbers[idx] - numbers[idx - 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int num = 2; num <= value; num++) {
            if (value % num == 0) {
                sb.append(num).append(' ');
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

