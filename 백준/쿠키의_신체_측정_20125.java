import java.io.*;

class Main {
    static int N;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        boolean check = true;
        int hY = 0, hX = 0;
        for (int y = 0; y < N; y++) {
            String mapX = br.readLine();
            for (int x = 0; x < N; x++) {
                map[y][x] = mapX.charAt(x);
                if (map[y][x] == '*' && check) {
                    hY = y + 1;
                    hX = x;
                    check = false;
                }
            }
        }
        bw.write((hY + 1) + " " + (hX + 1) + "\n");

        int count = 0;
        for (int x = hX - 1; x >= 0; x--) {
            if (map[hY][x] == '*') {
                count++;
            } else {
                break;
            }
        }
        bw.write(count + " ");

        count = 0;
        for (int x = hX + 1; x < N; x++) {
            if (map[hY][x] == '*') {
                count++;
            } else {
                break;
            }
        }
        bw.write(count + " ");

        int legY = 0;
        count = 0;
        for (int y = hY + 1; y < N; y++) {
            if (map[y][hX] == '*') {
                count++;
                legY = y;
            } else {
                break;
            }
        }
        bw.write(count + " ");

        count = 0;
        for (int y = legY + 1; y < N; y++) {
            if (map[y][hX - 1] == '*') {
                count++;
            } else {
                break;
            }
        }
        bw.write(count + " ");

        count = 0;
        for (int y = legY + 1; y < N; y++) {
            if (map[y][hX + 1] == '*') {
                count++;
            } else {
                break;
            }
        }
        bw.write(count + " ");

        bw.flush();
        br.close();
        bw.close();
    }
}

