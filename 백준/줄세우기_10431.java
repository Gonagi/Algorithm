import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int P = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= P; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int[] heights = new int[20];
            int count = 0;
            for (int idx = 0; idx < 20; idx++) {
                int height = Integer.parseInt(st.nextToken());
                int insertIdx = idx;

                for (int idx2 = 0; idx2 < idx; idx2++) {
                    if (height < heights[idx2]) {
                        insertIdx = idx2;
                        break;
                    }
                }

                count += idx - insertIdx;

                for (int idx2 = idx; idx2 > insertIdx; idx2--) {
                    heights[idx2] = heights[idx2 - 1];
                }
                heights[insertIdx] = height;
            }
            bw.write(testCase + " " + count + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

}

