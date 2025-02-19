import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int testCase = 1; testCase <= 10; testCase++) {
            int[] numbers = new int[8];
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            for (int idx = 0; idx < 8; idx++) {
                numbers[idx] = Integer.parseInt(st.nextToken());
                min = Math.min(min, numbers[idx]);
            }
 
            int minRemain = min % 15;
            Deque<Integer> result = new ArrayDeque<>();
            for (int idx = 0; idx < 8; idx++) {
                int remain = numbers[idx] % 15;
                if (remain < minRemain) {
                    result.add(remain + 30);
                } else {
                    result.add(remain + 15);
                }
            }
 
            int sub = 1;
            while (true) {
                int cur = result.pollFirst();
                int next = cur - sub;
                if (next <= 0) {
                    result.add(0);
                    break;
                }
                result.add(next);
                sub = (sub == 5) ? 1 : sub + 1;
            }
 
            bw.write("#" + t);
            for (int idx = 0; idx < 8; idx++) {
                bw.write(" " + result.poll());
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

