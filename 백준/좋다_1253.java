import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int idx = 0; idx < N; idx++) {
            A[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int count = 0;
        for (int idx = 0; idx < N; idx++) {
            int leftIdx = 0, rightIdx = N - 1;
            while (leftIdx < rightIdx) {
                if (leftIdx == idx) {
                    leftIdx++;
                } else if (rightIdx == idx) {
                    rightIdx--;
                } else {
                    int sum = A[leftIdx] + A[rightIdx];
                    if (sum == A[idx]) {
                        count++;
                        break;
                    } else if (sum < A[idx]) {
                        leftIdx++;
                    } else {
                        rightIdx--;
                    }
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}

