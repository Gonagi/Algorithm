import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] scores;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        if (N == 0) {
            bw.write(1 + "\n");
        } else {
            scores = new int[N];
            int inputScore = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int grade = 1, count = 1;
            st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < N; idx++) {
                scores[idx] = Integer.parseInt(st.nextToken());
                if (inputScore < scores[idx]) {
                    grade++;
                }
                if (inputScore <= scores[idx]) {
                    count++;
                }
            }

            if (count <= P) {
                bw.write(grade + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

