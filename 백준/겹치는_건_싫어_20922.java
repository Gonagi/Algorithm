import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            numbers[idx] = Integer.parseInt(st.nextToken());
        }

        int max = 0, start = 0, end = 0;
        int[] count = new int[100001];
        while (end < numbers.length) {
            while (end < numbers.length && count[numbers[end]] + 1 <= K) {
                count[numbers[end]]++;
                end++;
            }
            int length = end - start;
            max = Math.max(max, length);
            count[numbers[start]]--;
            start++;
        }

        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

