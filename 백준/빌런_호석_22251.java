import java.io.*;
import java.util.*;

public class Main {
    static int N, K, P, X, result;
    static int[][] diff = new int[10][10];
    static String[] segment = {
            "1111110",
            "0110000",
            "1101101",
            "1111001",
            "0110011",
            "1011011",
            "1011111",
            "1110000",
            "1111111",
            "1111011"
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        precomputeDiff();

        int[] origin = toDigits(X);

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            int[] target = toDigits(i);

            int totalDiff = 0;
            for (int d = 0; d < K; d++) {
                totalDiff += diff[origin[d]][target[d]];
                if (totalDiff > P) {
                    break;
                }
            }

            if (totalDiff <= P) {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void precomputeDiff() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int d = 0;
                for (int k = 0; k < 7; k++) {
                    if (segment[i].charAt(k) != segment[j].charAt(k)) {
                        d++;
                    }
                }
                diff[i][j] = d;
            }
        }
    }

    static int[] toDigits(int number) {
        int[] digits = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }
}

