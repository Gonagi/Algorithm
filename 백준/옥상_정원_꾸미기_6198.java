import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        for (int idx = 0; idx < N; idx++) {
            buildings[idx] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int idx = 0; idx < N; idx++) {
            while (!stack.isEmpty() && stack.peek() <= buildings[idx]) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(buildings[idx]);
        }

        System.out.println(answer);
        br.close();
    }
}

