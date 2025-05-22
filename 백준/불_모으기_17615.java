import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int result = Integer.MAX_VALUE;

        int count = 0;
        boolean check = false;
        for (int idx = 0; idx < N; idx++) {
            if (check && balls.charAt(idx) == 'R') {
                count++;
            } else if (balls.charAt(idx) == 'B') {
                check = true;
            }
        }
        result = Math.min(result, count);

        count = 0;
        check = false;
        for (int idx = 0; idx < N; idx++) {
            if (check && balls.charAt(idx) == 'B') {
                count++;
            } else if (balls.charAt(idx) == 'R') {
                check = true;
            }
        }
        result = Math.min(result, count);

        count = 0;
        check = false;
        for (int idx = N - 1; idx >= 0; idx--) {
            if (check && balls.charAt(idx) == 'R') {
                count++;
            } else if (balls.charAt(idx) == 'B') {
                check = true;
            }
        }
        result = Math.min(result, count);

        count = 0;
        check = false;
        for (int idx = N - 1; idx >= 0; idx--) {
            if (check && balls.charAt(idx) == 'B') {
                count++;
            } else if (balls.charAt(idx) == 'R') {
                check = true;
            }
        }
        result = Math.min(result, count);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

