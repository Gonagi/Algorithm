import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] buildings = new int[N + 1];
        int[] count = new int[N + 1], near = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
            near[i] = Integer.MIN_VALUE;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int idx = 1; idx <= N; idx++) {
            while (!stack.isEmpty()) {
                int maxHeightIdx = stack.peek();
                if (buildings[maxHeightIdx] > buildings[idx]) {
                    break;
                }
                stack.pop();
            }
            count[idx] = stack.size();
            if (count[idx] > 0)
                near[idx] = stack.peek();
            stack.push(idx);
        }

        stack = new ArrayDeque<>();
        for (int idx = N; idx > 0; idx--) {
            while (!stack.isEmpty()) {
                if (buildings[stack.peek()] > buildings[idx]) {
                    break;
                }
                stack.pop();
            }
            int s = stack.size();
            count[idx] += s;
            if (s > 0 && (near[idx] == Integer.MIN_VALUE || stack.peek() - idx < idx - near[idx]))
                near[idx] = stack.peek();
            stack.push(idx);
        }

        for (int idx = 1; idx <= N; idx++) {
            bw.write(count[idx] + "");
            if (count[idx] > 0) {
                bw.write(" " + near[idx]);
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

