import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        long start = 1, end = 2;

        StringBuilder sb = new StringBuilder();
        while (end < 100_000) {
            long powStart = start * start;
            long powEnd = end * end;

            if (powEnd - powStart == G) {
                sb.append(end).append('\n');
            }

            if (powEnd - powStart > G) {
                start++;
            } else {
                end++;
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        System.out.println(sb);
        br.close();
    }
}

