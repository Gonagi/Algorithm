import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[b + 1];
        check[1] = true;
        StringBuilder sb = new StringBuilder();
        for (int num = 2; num * num <= b; num++) {
            if (check[num]) {
                continue;
            }
            for (int num2 = num * num; num2 <= b; num2 += num) {
                check[num2] = true;
            }
        }

        for (int num = a; num <= b; num++) {
            if (!check[num]) {
                if (isPalindRoom(num)) {
                    sb.append(num).append('\n');
                }
            }
        }
        sb.append("-1\n");
        System.out.println(sb);
        br.close();
    }

    private static boolean isPalindRoom(int num) {
        String cur = String.valueOf(num);
        int size = cur.length();
        for (int idx = 0; idx < size / 2; idx++) {
            if (cur.charAt(idx) != cur.charAt(size - idx - 1)) {
                return false;
            }
        }

        return true;
    }
}

