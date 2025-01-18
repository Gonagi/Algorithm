import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger[] nums = new BigInteger[10001];
        nums[0] = BigInteger.ZERO;
        nums[1] = BigInteger.ONE;

        for (int idx = 2; idx <= N; idx++) {
            nums[idx] = nums[idx - 1].add(nums[idx - 2]);
        }

        System.out.println(nums[N]);
        br.close();
    }
}
