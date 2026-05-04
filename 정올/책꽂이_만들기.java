import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> que = new PriorityQueue<>();

        for (int idx = 0; idx < N; idx++) {
            que.add(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while (que.size() > 1) {
            long sum = que.poll() + que.poll();
            result += sum;
            que.add(sum);
        }

        System.out.println(result);
        br.close();   
    }
}

