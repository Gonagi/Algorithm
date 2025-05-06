import java.io.*;
import java.util.*;

class Main {
    static int N, X;
    static int[] visitors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visitors = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            visitors[idx] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int idx = 0; idx < X; idx++) {
            sum += visitors[idx];
        }

        int max = sum;
        int count = 1;
        for (int idx = X; idx < N; idx++) {
            sum += visitors[idx];
            sum -= visitors[idx - X];
            if (max <= sum) {
                if (max < sum) {
                    max = sum;
                    count = 1;
                } else {
                    count++;
                }
            }
        }

        if (max == 0) {
            bw.write("SAD\n");
        } else {
            bw.write(max + "\n");
            bw.write(count + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

