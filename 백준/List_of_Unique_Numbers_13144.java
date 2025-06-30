import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            numbers[idx] = Integer.parseInt(st.nextToken());
        }

        boolean[] check = new boolean[100001];
        long result = 0;
        int start = 0;

        for (int end = 0; end < N; end++) {
            while (check[numbers[end]]) {
                check[numbers[start]] = false;
                start++;
            }
            check[numbers[end]] = true;
            result += (end - start + 1);
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

