import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new ArrayDeque<>();
        Deque<Integer> wQue = new ArrayDeque<>();
        for (int idx = 0; idx < w; idx++) {
            wQue.add(0);
        }
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            que.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int weightSum = 0;
        while (true) {
            if (que.isEmpty() && weightSum == 0) {
                break;
            }

            int firstWeight = wQue.pollFirst();
            if (firstWeight > 0) {
                weightSum -= firstWeight;
            }

            if (!que.isEmpty()) {

                int cur = que.peek();
                if (weightSum + cur <= L) {
                    que.poll();
                    weightSum += cur;
                    wQue.addLast(cur);
                } else {
                    wQue.addLast(0);
                }
            } else {
                wQue.addLast(0);
            }

            time++;
        }

        bw.write(String.valueOf(time));
        bw.newLine();

        bw.flush();
        br.close();
        bw.close();
    }
}

