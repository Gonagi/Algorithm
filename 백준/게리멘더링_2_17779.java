import java.io.*;
import java.util.*;

public class Main {
    static int[][] A;
    static int N, result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                A[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {
                            simulation(x, y, d1, d2);
                        }
                    }
                }
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void simulation(int x, int y, int d1, int d2) {
        int[][] numberMap = new int[N + 1][N + 1];
        for (int idx = 1; idx <= N; idx++) {
            Arrays.fill(numberMap[idx], -1);
        }

        for (int idx = 0; idx <= d1; idx++) {
            numberMap[x + idx][y - idx] = 5;
        }

        for (int idx = 0; idx <= d2; idx++) {
            numberMap[x + idx][y + idx] = 5;
        }

        for (int idx = 0; idx <= d2; idx++) {
            numberMap[x + d1 + idx][y - d1 + idx] = 5;
        }

        for (int idx = 0; idx <= d1; idx++) {
            numberMap[x + d2 + idx][y + d2 - idx] = 5;
        }

        for (int idx = x + 1; idx < x + d1 + d2; idx++) {
            boolean inside = false;
            for (int idx2 = 1; idx2 <= N; idx2++) {
                if (numberMap[idx][idx2] == 5) {
                    inside = !inside;
                }
                if (inside) {
                    numberMap[idx][idx2] = 5;
                }
            }
        }

        int one = 0, two = 0, three = 0, four = 0, five = 0;
        for (int idx = 1; idx < x + d1; idx++) {
            for (int idx2 = 1; idx2 <= y; idx2++) {
                if (numberMap[idx][idx2] == 5) {
                    break;
                }
                one += A[idx][idx2];
            }
        }

        for (int idx = 1; idx <= x + d2; idx++) {
            for (int idx2 = N; idx2 > y; idx2--) {
                if (numberMap[idx][idx2] == 5) {
                    break;
                }
                two += A[idx][idx2];
            }
        }

        for (int idx = x + d1; idx <= N; idx++) {
            for (int idx2 = 1; idx2 < y - d1 + d2; idx2++) {
                if (numberMap[idx][idx2] == 5) {
                    break;
                }
                three += A[idx][idx2];
            }
        }

        for (int idx = x + d2 + 1; idx <= N; idx++) {
            for (int idx2 = N; idx2 >= y - d1 + d2; idx2--) {
                if (numberMap[idx][idx2] == 5) {
                    break;
                }
                four += A[idx][idx2];
            }
        }

        int total = 0;
        for (int idx = 1; idx <= N; idx++) {
            for (int idx2 = 1; idx2 <= N; idx2++) {
                total += A[idx][idx2];
            }
        }
        five = total - (one + two + three + four);

        int max = Math.max(one, Math.max(two, Math.max(three, Math.max(four, five))));
        int min = Math.min(one, Math.min(two, Math.min(three, Math.min(four, five))));
        result = Math.min(result, max - min);
    }
}

