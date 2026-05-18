import java.io.*;

public class Main {
    static int N;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();

        result = new int[N];

        dfs(0);
    }

    private static void dfs(int cur) {
        if (cur == N) {
            StringBuilder sb = new StringBuilder();
            for (int n : result) {
                sb.append(n);
            }
            System.out.println(sb);
            System.exit(0);
        }

        for (int num = 1; num <= 3; num++) {
            result[cur] = num;
            if (isPass(cur)) {
                dfs(cur + 1);
            }
        }
    }

    private static boolean isPass(int cur) {
        int length = cur + 1;

        for (int size = 1; size <= length / 2; size++) {
            boolean same = true;

            for (int idx = 0; idx < size; idx++) {
                int left = length - size * 2 + idx;
                int right = length - size + idx;

                if (result[left] != result[right]) {
                    same = false;
                    break;
                }
            }

            if (same) {
                return false;
            }
        }

        return true;
    }
}

