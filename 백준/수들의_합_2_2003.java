import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            A[idx] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int sum = 0, result = 0;
        while (true) {
            if (sum >= M) {
                sum -= A[left++];
            } else {
                if (right == N) {
                    break;
                }
                sum += A[right++];
            }

            if (sum == M) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }
}

