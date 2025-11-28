import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dna = new String[N];

        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();
        int totalHamming = 0;

        for (int y = 0; y < M; y++) {
            int[] count = new int[4];

            for (int x = 0; x < N; x++) {
                char c = dna[x].charAt(y);
                if (c == 'A') {
                    count[0]++;
                } else if (c == 'C') {
                    count[1]++;
                } else if (c == 'G') {
                    count[2]++;
                } else {
                    count[3]++;
                }
            }

            int maxIdx = 0;
            for (int i = 1; i < 4; i++) {
                if (count[i] > count[maxIdx]) {
                    maxIdx = i;
                }
            }

            char selected;
            if (maxIdx == 0) {
                selected = 'A';
            } else if (maxIdx == 1) {
                selected = 'C';
            } else if (maxIdx == 2) {
                selected = 'G';
            } else {
                selected = 'T';
            }

            result.append(selected);

            for (int x = 0; x < N; x++) {
                if (dna[x].charAt(y) != selected) {
                    totalHamming++;
                }
            }
        }

        bw.write(result.toString());
        bw.newLine();
        bw.write(String.valueOf(totalHamming));

        bw.flush();
        br.close();
        bw.close();
    }
}

