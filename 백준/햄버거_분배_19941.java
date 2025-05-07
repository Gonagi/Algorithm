import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, K;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String lines = br.readLine();
        boolean[] visited = new boolean[N];

        int result = 0;
        for (int idx = 0; idx < N; idx++) {
            if (lines.charAt(idx) == 'P') {
                for (int c = idx - K; c <= idx + K; c++) {
                    if (c < 0 || c >= N) {
                        continue;
                    }
                    if (lines.charAt(c) == 'H' && !visited[c]) {
                        visited[c] = true;
                        result++;
                        break;
                    }
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

