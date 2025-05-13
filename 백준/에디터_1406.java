import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            left.add(ch);
        }

        for (int idx = 0; idx < M; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("L")) {
                if (!left.isEmpty()) {
                    right.addFirst(left.removeLast());
                }
            } else if (command.equals("D")) {
                if (!right.isEmpty()) {
                    left.addLast(right.removeFirst());
                }
            } else if (command.equals("B")) {
                if (!left.isEmpty()) {
                    left.removeLast();
                }
            } else if (command.equals("P")) {
                char newInput = st.nextToken().charAt(0);
                left.addLast(newInput);
            }
        }

        for (char ch : left) {
            bw.write(ch);
        }
        for (char ch : right) {
            bw.write(ch);
        }
        
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}

