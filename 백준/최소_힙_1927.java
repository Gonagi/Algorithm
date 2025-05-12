import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int idx = 0; idx < N; idx++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (que.size() == 0) {
                    bw.write("0\n");
                } else {
                    bw.write(que.poll() + "\n");
                }
            } else {
                que.add(num);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

