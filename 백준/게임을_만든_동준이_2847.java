import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        for (int idx = 0; idx < N; idx++) {
            num[idx] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int idx = N - 2; idx >= 0; idx--) {
            if (num[idx + 1] <= num[idx]) {
                int count = num[idx] - num[idx + 1] + 1;
                num[idx] -= count;
                result += count;
            }
        }

        System.out.println(result);
        br.close();
    }
}

