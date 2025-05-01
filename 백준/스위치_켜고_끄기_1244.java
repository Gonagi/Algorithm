import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] switches;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        switches = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            switches[idx] = Integer.parseInt(st.nextToken());
        }

        int count = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < count; idx++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            if (sex == 1) {
                change1(Integer.parseInt(st.nextToken()));
            } else {
                change2(Integer.parseInt(st.nextToken()));
            }
        }

        for (int idx = 1; idx <= N; idx++) {
            bw.write(switches[idx] + " ");
            if (idx % 20 == 0) {
                bw.newLine();
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void change1(int n) {
        for (int idx = n; idx <= N; idx += n) {
            switches[idx] = switches[idx] == 1 ? 0 : 1;
        }
    }

    static void change2(int n) {
        int check = 0;
        while (true) {
            if (!(n - check >= 1 && n + check <= N) || (switches[n - check] != switches[n + check])) {
                check--;
                break;
            }
            check++;
        }

        for (int idx = n - check; idx <= n + check; idx++) {
            switches[idx] = switches[idx] == 1 ? 0 : 1;
        }
    }
}

