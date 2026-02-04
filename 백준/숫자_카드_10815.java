import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            card[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < M; idx++) {
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;
            boolean check = false;
            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (num < card[middle]) {
                    right = middle - 1;
                } else if (num == card[middle]) {
                    sb.append("1 ");
                    check = true;
                    break;
                } else {
                    left = middle + 1;
                }
            }
            if (!check) {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}

