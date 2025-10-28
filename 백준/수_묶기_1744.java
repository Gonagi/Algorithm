import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        boolean hasZero = false;

        for (int idx = 0; idx < N; idx++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                list1.add(num);
            } else if (num < 0) {
                list2.add(num);
            } else {
                hasZero = true;
            }
        }

        int[] priceNum = list1.stream().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] minusNum = list2.stream().sorted().mapToInt(Integer::intValue).toArray();

        long sum = 0;
        for (int idx = 0; idx < priceNum.length; idx++) {
            if (idx + 1 < priceNum.length && priceNum[idx] > 1 && priceNum[idx + 1] > 1) {
                sum += priceNum[idx] * priceNum[idx + 1];
                idx++;
            } else {
                sum += priceNum[idx];
            }
        }

        for (int idx = 0; idx < minusNum.length; idx++) {
            if (idx + 1 < minusNum.length) {
                sum += minusNum[idx] * minusNum[idx + 1];
                idx++;
            } else if (!hasZero) {
                sum += minusNum[idx];
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

