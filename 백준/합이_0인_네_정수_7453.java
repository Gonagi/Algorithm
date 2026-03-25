import java.io.*;
import java.util.*;

public class Main {
    static int[] A, B, C, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];
        for (int idx = 0; idx < n; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[idx] = Integer.parseInt(st.nextToken());
            B[idx] = Integer.parseInt(st.nextToken());
            C[idx] = Integer.parseInt(st.nextToken());
            D[idx] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[n * n];
        int[] CD = new int[n * n];
        int i = 0;
        for (int idx = 0; idx < n; idx++) {
            for (int idx2 = 0; idx2 < n; idx2++) {
                AB[i] = A[idx] + B[idx2];
                CD[i] = C[idx] + D[idx2];
                i++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0, right = n * n - 1;
        long result = 0;
        while (left < n * n && right >= 0) {
            int sum = AB[left] + CD[right];
            if (sum == 0) {
                int val1 = AB[left];
                int leftCount = 0;
                while (left < n * n && AB[left] == val1) {
                    left++;
                    leftCount++;
                }

                int val2 = CD[right];
                int rightCount = 0;
                while (right >= 0 && CD[right] == val2) {
                    right--;
                    rightCount++;
                }

                result += (long) leftCount * rightCount;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result);
        br.close();
    }
}

