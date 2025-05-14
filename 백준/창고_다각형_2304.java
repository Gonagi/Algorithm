import java.io.*;
import java.util.*;

class Main {
    static class Bar implements Comparable<Bar> {
        int x, y;

        public Bar(int x, int y) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Bar o) {
            return Integer.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Bar[] bars = new Bar[N];

        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            bars[idx] = new Bar(L, H);
        }

        Arrays.sort(bars);

        int maxY = 0, maxX = 0, maxLength = 0;
        for (int idx = 0; idx < N; idx++) {
            int curY = bars[idx].y;
            int curX = bars[idx].x;

            if (maxY < curY) {
                maxY = curY;
                maxX = curX;
                maxLength = 1;
            } else if (maxY == curY) {
                maxLength = curX - maxX + 1;
            }
        }

        int sum = 0;
        int curHeight = bars[0].y;
        int curX = bars[0].x;
        for (int idx = 0; idx < N; idx++) {
            if (curHeight == maxY) {
                break;
            }
            if (curHeight < bars[idx].y) {
                sum += (curHeight * (bars[idx].x - curX));
                curHeight = bars[idx].y;
                curX = bars[idx].x;
            }
        }
        
        curHeight = bars[N - 1].y;
        curX = bars[N - 1].x;
        for (int idx = N - 1; idx >= 0; idx--) {
            if (curHeight == maxY) {
                break;
            }
            if (curHeight < bars[idx].y) {
                sum += (curHeight * (curX - bars[idx].x));
                curHeight = bars[idx].y;
                curX = bars[idx].x;
            }
        }
        
        sum += (maxY * maxLength);
        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

