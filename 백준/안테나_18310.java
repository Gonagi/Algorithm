import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        if (N % 2 == 0) {
            System.out.println(input[N / 2 - 1]);
        } else {
            System.out.println(input[N / 2]);
        }
        br.close();
    }
}

