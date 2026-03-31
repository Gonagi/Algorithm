import java.io.*;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static char[] input;
    static int[] number;
    static char[] operator;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[(N + 1) / 2];
        operator = new char[N / 2];
        input = br.readLine().toCharArray();
        int idx = 0, idx2 = 0;
        for (char ch : input) {
            if (Character.isDigit(ch)) {
                number[idx++] = ch - '0';
            } else {
                operator[idx2++] = ch;
            }
        }
        dfs(0, input[0] - '0');
        System.out.println(max);
        br.close();
    }

    private static void dfs(int idx, int num) {
        if (idx == N / 2) {
            max = Math.max(max, num);
            return;
        }

        int result = calc(operator[idx], num, number[idx + 1]);
        dfs(idx + 1, result);

        if (idx + 1 < N / 2) {
            result = calc(operator[idx + 1], number[idx + 1], number[idx + 2]);
            dfs(idx + 2, calc(operator[idx], num, result));
        }
    }

    private static int calc(char operator, int n1, int n2) {
        switch (operator) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return -1;
    }
}

