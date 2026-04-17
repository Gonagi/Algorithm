import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        Deque<Character> stack = new ArrayDeque<>();
        int size = input.length();
        for (int idx = 0; idx < size; idx++) {
            stack.addLast(input.charAt(idx));

            if (stack.size() >= 4) {
                char ch1 = stack.pollLast();
                char ch2 = stack.pollLast();
                char ch3 = stack.pollLast();
                char ch4 = stack.pollLast();

                if (ch1 == 'P' && ch2 == 'A' && ch3 == 'P' && ch4 == 'P') {
                    stack.addLast('P');
                } else {
                    stack.addLast(ch4);
                    stack.addLast(ch3);
                    stack.addLast(ch2);
                    stack.addLast(ch1);
                }
            }
        }

        if (stack.size() == 1 && stack.peekLast() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}

