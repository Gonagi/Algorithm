import java.io.*;
import java.util.*;

public class Main {
    static int H, W, N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int y = 0; y < H; y += (N + 1)) {
            for (int x = 0; x < W; x += (M + 1)) {
                count++;
            }
        }
        bw.write(count + "\n");

        br.close();
        bw.close();
    }
}

