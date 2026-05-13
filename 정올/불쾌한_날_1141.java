import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        long answer = 0;

        for (int idx = 0; idx < N; idx++) {
            int current = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            answer += stack.size();
            stack.push(current);
        }

        System.out.println(answer);
        br.close();
    }
}

