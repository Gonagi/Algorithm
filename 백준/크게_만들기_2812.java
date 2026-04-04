import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        int[] num = new int[input.length()];
        for (int idx = 0; idx < input.length(); idx++) {
            num[idx] = input.charAt(idx) - '0';
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int idx = 0; idx < N; idx++) {
            while (!stack.isEmpty() && K > 0 && stack.peekLast() < num[idx]) {
                stack.pollLast();
                K--;
            }
            stack.addLast(num[idx]);
        }

        while (K-- > 0) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        System.out.println(sb);
        br.close();
    }
}

