import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int idx = 0; idx < N; idx++) {
            String input = br.readLine();
            set.add(input);
        }

        int count = 0;
        for (int idx = 0; idx < M; idx++) {
            String inputs = br.readLine();
            String[] words = inputs.split(",");
            for (String word : words) {
                if (set.contains(word)) {
                    count++;
                    set.remove(word);
                }
            }
            bw.write((N - count) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

