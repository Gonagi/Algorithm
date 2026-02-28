import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pQue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            pQue.add(Long.parseLong(st.nextToken()));
        }

        for (int idx = 0; idx < m; idx++) {
            long num1 = pQue.poll();
            long num2 = pQue.poll();
            pQue.add(num1 + num2);
            pQue.add(num1 + num2);
        }

        long result = 0;
        for (long num : pQue) {
            result += num;
        }

        System.out.println(result);
        br.close();

    }
}

