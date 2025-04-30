import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int need = calNeed(game);

        Set<String> players = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            players.add(name);
        }

        int maxGames = players.size() / need;
        bw.write(maxGames + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static int calNeed(String game) {
        if (game.equals("Y")) {
            return 1;
        } else if (game.equals("F")) {
            return 2;
        }
        return 3;
    }
}

