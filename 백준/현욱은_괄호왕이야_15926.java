import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int max = 0;
        for (int idx = 0; idx < n; idx++) {
            char ch = input.charAt(idx);
            if (ch == '(') {
                stack.push(idx);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(idx);
                } else {
                    max = Math.max(max, idx - stack.peek());
                }
            }
        }

        System.out.println(max);
        br.close();
    }
}

