import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int idx = 0; idx < N; idx++) {
            words[idx] = br.readLine();
        }

        int maxLength = 0;
        int resultIdx1 = 0, resultIdx2 = 0;
        for (int idx = 0; idx < N; idx++) {
            String frontWord = words[idx];
            int frontLength = frontWord.length();
            for (int idx2 = idx + 1; idx2 < N; idx2++) {
                String backWord = words[idx2];
                int backLength = backWord.length();
                int minLength = Math.min(frontLength, backLength);
                if (minLength <= maxLength) {
                    continue;
                }

                for (int idx3 = 0; idx3 < minLength; idx3++) {
                    if (frontWord.charAt(idx3) != backWord.charAt(idx3)) {
                        break;
                    }

                    if (maxLength < idx3 + 1) {
                        maxLength = idx3 + 1;
                        resultIdx1 = idx;
                        resultIdx2 = idx2;
                    }
                }
            }
        }

        bw.write(words[resultIdx1] + "\n" + words[resultIdx2]);

        bw.flush();
        br.close();
        bw.close();
    }
}

