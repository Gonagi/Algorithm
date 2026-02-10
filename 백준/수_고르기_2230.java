import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        for (int idx = 0; idx < N; idx++) {
            A[idx] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        int right = 0, result = Integer.MAX_VALUE;
        for (int left = 0; left < N; left++) {
            while (right < N && A[right] - A[left] < M) {
                right++;
            }
            if (right < N) {
                result = Math.min(result, A[right] - A[left]);
            }
        }

        System.out.println(result);
        br.close();
    }
}

