import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int temp = 1;
        int result = 0;

        for (int idx = 0; idx < input.length(); idx++) {
            char curChar = input.charAt(idx);
            if (curChar == '(') {
                temp *= 2;
                stack.push(curChar);
            } else if (curChar == '[') {
                temp *= 3;
                stack.push(curChar);
            } else if (curChar == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (input.charAt(idx - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (input.charAt(idx - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        System.out.println(stack.isEmpty() ? result : 0);
        br.close();
    }
}

