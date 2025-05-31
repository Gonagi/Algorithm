import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        int[] check = new int[d + 1];

        for (int idx = 0; idx < N; idx++) {
            numbers[idx] = Integer.parseInt(br.readLine());
        }

        int result = 0, count = 0;
        for (int idx = 0; idx < k; idx++) {
            check[numbers[idx]]++;
        }
        for (int idx = 1; idx <= d; idx++) {
            if (check[idx] > 0) {
                count++;
            }
        }

        for (int idx = 0; idx < N; idx++) {
            int prevNum = numbers[idx];
            check[prevNum]--;
            if (check[prevNum] == 0) {
                count--;
            }

            int idx2 = (idx + k) >= N ? (idx + k) - N : idx + k;
            int curNum = numbers[idx2];
            check[curNum]++;
            if (check[curNum] == 1) {
                count++;
            }

            if (check[c] == 0) {
                result = Math.max(result, ++count);
                count--;
            } else {
                result = Math.max(result, count);
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

