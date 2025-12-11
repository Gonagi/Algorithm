import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            String input = br.readLine();
            int size = input.length();

            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            for (int idx = 0; idx < size; idx++) {
                char curChar = input.charAt(idx);
                if (curChar == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }

                } else if (curChar == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (curChar == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(curChar);
                }
            }

            Collections.reverse(leftStack);
            while (!leftStack.isEmpty()) {
                bw.write(leftStack.pop());
            }
            while (!rightStack.isEmpty()) {
                bw.write(rightStack.pop());
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

