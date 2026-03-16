import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int idx = 0; idx < K; idx++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pollLast();
            } else {
                stack.add(num);
            }
        }

        int sum = 0;
        for (int num : stack) {
            sum += num;
        }

        System.out.println(sum);
        br.close();
    }
}

