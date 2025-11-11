import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < R; t++) {
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                for (int i = 0; i < N / 2; i++) {
                    int[] temp = map[i];
                    map[i] = map[N - 1 - i];
                    map[N - 1 - i] = temp;
                }
            } else if (op == 2) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        int tmp = map[i][j];
                        map[i][j] = map[i][M - 1 - j];
                        map[i][M - 1 - j] = tmp;
                    }
                }
            } else if (op == 3) {
                int[][] temp = new int[M][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        temp[j][N - 1 - i] = map[i][j];
                    }
                }
                map = temp;
                int tmp = N;
                N = M;
                M = tmp;
            } else if (op == 4) {
                int[][] temp = new int[M][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        temp[M - 1 - j][i] = map[i][j];
                    }
                }
                map = temp;
                int tmp = N;
                N = M;
                M = tmp;
            } else if (op == 5) {
                int[][] temp = new int[N][M];
                int halfN = N / 2, halfM = M / 2;
                for (int i = 0; i < halfN; i++) {
                    for (int j = 0; j < halfM; j++) {
                        temp[i][j + halfM] = map[i][j];
                    }
                }
                for (int i = 0; i < halfN; i++) {
                    for (int j = halfM; j < M; j++) {
                        temp[i + halfN][j] = map[i][j];
                    }
                }
                for (int i = halfN; i < N; i++) {
                    for (int j = halfM; j < M; j++) {
                        temp[i][j - halfM] = map[i][j];
                    }
                }
                for (int i = halfN; i < N; i++) {
                    for (int j = 0; j < halfM; j++) {
                        temp[i - halfN][j] = map[i][j];
                    }
                }
                map = temp;
            } else {
                int[][] temp = new int[N][M];
                int halfN = N / 2, halfM = M / 2;
                for (int i = 0; i < halfN; i++) {
                    for (int j = 0; j < halfM; j++) {
                        temp[i + halfN][j] = map[i][j];
                    }
                }
                for (int i = halfN; i < N; i++) {
                    for (int j = 0; j < halfM; j++) {
                        temp[i][j + halfM] = map[i][j];
                    }
                }
                for (int i = halfN; i < N; i++) {
                    for (int j = halfM; j < M; j++) {
                        temp[i - halfN][j] = map[i][j];
                    }
                }
                for (int i = 0; i < halfN; i++) {
                    for (int j = halfM; j < M; j++) {
                        temp[i][j - halfM] = map[i][j];
                    }
                }
                map = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

