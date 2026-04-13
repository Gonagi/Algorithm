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

        long sum = 0;
        for (int idx = 0; idx < N; idx++) {
            if (input[idx] > sum + 1) {
                break;
            }
            sum += input[idx];
        }
        System.out.println(sum + 1);
        br.close();
    }
}

