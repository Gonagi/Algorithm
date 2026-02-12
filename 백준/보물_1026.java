import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            A[idx] = Integer.parseInt(st.nextToken());
            B[idx] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        for (int idx = 0; idx < N; idx++) {
            result += A[idx] * B[N - idx - 1];
        }
        System.out.println(result);
        br.close();
    }
}

