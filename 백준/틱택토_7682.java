import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] map = new char[3][3];

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }

            int oCount = 0, xCount = 0;
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    map[y][x] = input.charAt(3 * y + x);
                    if (map[y][x] == 'O') {
                        oCount++;
                    } else if (map[y][x] == 'X') {
                        xCount++;
                    }
                }
            }

            if (!(xCount == oCount || xCount == (oCount + 1))) {
                bw.write("invalid\n");
                continue;
            }

            boolean xWin = checkRow(map, 'X') || checkCol(map, 'X') || checkDiag(map, 'X');
            boolean oWin = checkRow(map, 'O') || checkCol(map, 'O') || checkDiag(map, 'O');

            if (xWin && oWin) {
                bw.write("invalid\n");
            } else if (xWin && xCount == oCount + 1) {
                bw.write("valid\n");
            } else if (oWin && xCount == oCount) {
                bw.write("valid\n");
            } else if (!xWin && !oWin && xCount + oCount == 9) {
                bw.write("valid\n");
            } else {
                bw.write("invalid\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static boolean checkRow(char[][] map, char c) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == c && map[i][1] == c && map[i][2] == c)
                return true;
        }
        return false;
    }

    static boolean checkCol(char[][] map, char c) {
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == c && map[1][i] == c && map[2][i] == c)
                return true;
        }
        return false;
    }

    static boolean checkDiag(char[][] map, char c) {
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c)
            return true;
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c)
            return true;
        return false;
    }
}

