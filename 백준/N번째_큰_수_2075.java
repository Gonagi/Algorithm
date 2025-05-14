import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                que.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int result = 1;; result++) {
            int num = que.poll();
            if (result == N) {
                bw.write(num + "\n");
                break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

