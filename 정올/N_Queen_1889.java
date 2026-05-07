import java.io.*;

public class Main {
    static int N, count = 0;
    static boolean[] col, diag1, diag2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];
        backtrack(0);
        System.out.println(count);
        br.close();
    }

    private static void backtrack(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int x = 0; x < N; x++) {
            if (col[x] || diag1[row + x] || diag2[row - x + N - 1]) {
                continue;
            }
            col[x] = true;
            diag1[row + x] = true;
            diag2[row - x + N - 1] = true;
            backtrack(row + 1);
            col[x] = false;
            diag1[row + x] = false;
            diag2[row - x + N - 1] = false;
        }
    }
}

