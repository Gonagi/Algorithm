import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Queue<Integer> aQue = new ArrayDeque<>();
        Queue<Integer> bQue = new ArrayDeque<>();

        int result = 0;
        int length = S.length();
        for (int idx = 0; idx < length; idx++) {
            char ch = S.charAt(idx);
            if (ch == 'A') {
                aQue.add(idx);
            } else if (ch == 'B') {
                bQue.add(idx);
            } else {
                if (!bQue.isEmpty()) {
                    result++;
                    bQue.poll();
                }
            }
        }

        while (!aQue.isEmpty() && !bQue.isEmpty()) {
            if (aQue.peek() < bQue.peek()) {
                result++;
                aQue.poll();
                bQue.poll();
            } else {
                bQue.poll();
            }
        }

        System.out.println(result);
        br.close();
    }
}

