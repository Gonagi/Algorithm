import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<String> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < N; idx++) {
            int input = Integer.parseInt(br.readLine());
            result = new ArrayList<>();
            DFS(2, input, "1");

            Collections.sort(result);
            for (String s : result) {
                bw.write(s + "\n");
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void DFS(int cur, int input, String str) throws Exception {
        if (cur > input) {
            String formula = str.replaceAll(" ", "");
            if (cal(formula) == 0) {
                result.add(str);
            }
            return;
        }

        DFS(cur + 1, input, str + " " + cur);
        DFS(cur + 1, input, str + "+" + cur);
        DFS(cur + 1, input, str + "-" + cur);
    }

    private static int cal(String formula) {
        StringTokenizer st = new StringTokenizer(formula, "+-", true);
        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String cur = st.nextToken();
            if (cur.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            } else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        return sum;
    }
}

