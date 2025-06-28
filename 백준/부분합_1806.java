import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int sum, length;

        public Node(int sum, int length) {
            this.sum = sum;
            this.length = length;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            numbers[idx] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        while (end <= N) {
            if (sum >= S) {
                min = Math.min(min, end - start);
                sum -= numbers[start++];
            } else {
                sum += numbers[end++];
            }
        }

        bw.write(((min == Integer.MAX_VALUE) ? 0 : min) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

