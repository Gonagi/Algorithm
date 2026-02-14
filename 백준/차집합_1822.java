import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] A = new int[a];
        int[] B = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < a; idx++) {
            A[idx] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < b; idx++) {
            B[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int idx = 0; idx < a; idx++) {
            int target = A[idx];
            int left = 0;
            int right = b - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (B[middle] < target) {
                    left = middle + 1;
                } else if (B[middle] == target) {
                    break;
                } else {
                    right = middle - 1;
                }
            }
            if (left > right) {
                sb.append(target).append(' ');
                count++;
            }
        }
        System.out.println(count);
        if (count != 0) {
            System.out.println(sb);
        }
        br.close();
    }
}

