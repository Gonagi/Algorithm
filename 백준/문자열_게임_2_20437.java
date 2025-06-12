import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            List<Integer>[] list = new ArrayList[26];
            for (int idx = 0; idx < 26; idx++) {
                list[idx] = new ArrayList<>();
            }

            for (int idx = 0; idx < W.length(); idx++) {
                list[W.charAt(idx) - 'a'].add(idx);
            }

            int shortest = Integer.MAX_VALUE, longest = 0;
            for (int idx = 0; idx < 26; idx++) {
                if (list[idx].size() < K) {
                    continue;
                }

                for (int idx2 = 0; idx2 <= list[idx].size() - K; idx2++) {
                    int cal = list[idx].get(idx2 + K - 1) - list[idx].get(idx2) + 1;
                    shortest = Math.min(shortest, cal);
                    longest = Math.max(longest, cal);
                }
            }

            if (shortest == Integer.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(shortest + " " + longest + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

