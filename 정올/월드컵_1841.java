import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int win, draw, lose;

        public Node(int win, int draw, int lose) {
            this.win = win;
            this.draw = draw;
            this.lose = lose;
        }
    }

    static Node[] country = new Node[6];
    static boolean check = false;

    static int[] teamA = new int[15];
    static int[] teamB = new int[15];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (int a = 0; a < 6; a++) {
            for (int b = a + 1; b < 6; b++) {
                teamA[i] = a;
                teamB[i] = b;
                i++;
            }
        }

        for (int idx = 0; idx < 4; idx++) {
            check = false;
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean check2 = true;
            for (int idx2 = 0; idx2 < 6; idx2++) {
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());
                country[idx2] = new Node(win, draw, lose);
                if ((win + draw + lose) != 5) {
                    check2 = false;
                }
            }
            if (check2) {
                backtrack(0);
            }
            sb.append(check ? 1 : 0).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    private static void backtrack(int cur) {
        if (check) {
            return;
        }

        if (cur == 15) {
            check = true;
            return;
        }

        int a = teamA[cur];
        int b = teamB[cur];

        if (country[a].win > 0 && country[b].lose > 0) {
            country[a].win--;
            country[b].lose--;
            backtrack(cur + 1);
            country[a].win++;
            country[b].lose++;
        }

        if (country[a].draw > 0 && country[b].draw > 0) {
            country[a].draw--;
            country[b].draw--;
            backtrack(cur + 1);
            country[a].draw++;
            country[b].draw++;
        }

        if (country[a].lose > 0 && country[b].win > 0) {
            country[a].lose--;
            country[b].win--;
            backtrack(cur + 1);
            country[a].lose++;
            country[b].win++;
        }
    }
}

