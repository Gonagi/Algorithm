import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, maxBlack, maxWhite;
    static int[][] map;
    static boolean[] diag1, diag2;
    static List<Node> blackList = new ArrayList<>(), whiteList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) {
                    if ((y + x) % 2 == 0) {
                        blackList.add(new Node(y, x));
                    } else {
                        whiteList.add(new Node(y, x));
                    }
                }
            }
        }

        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];
        blackDfs(0, 0);
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];
        whiteDfs(0, 0);

        System.out.println(maxBlack + maxWhite);
        br.close();
    }

    private static void blackDfs(int idx, int count) {
        if (idx >= blackList.size()) {
            maxBlack = Math.max(maxBlack, count);
            return;
        }
        Node curNode = blackList.get(idx);
        int curDir1 = curNode.y + curNode.x;
        int curDir2 = curNode.y - curNode.x + N;

        if (!diag1[curDir1] && !diag2[curDir2]) {
            diag1[curDir1] = true;
            diag2[curDir2] = true;
            blackDfs(idx + 1, count + 1);
            diag1[curDir1] = false;
            diag2[curDir2] = false;
        }
        blackDfs(idx + 1, count);
    }

    private static void whiteDfs(int idx, int count) {
        if (idx >= whiteList.size()) {
            maxWhite = Math.max(maxWhite, count);
            return;
        }
        Node curNode = whiteList.get(idx);
        int curDir1 = curNode.y + curNode.x;
        int curDir2 = curNode.y - curNode.x + N;

        if (!diag1[curDir1] && !diag2[curDir2]) {
            diag1[curDir1] = true;
            diag2[curDir2] = true;
            whiteDfs(idx + 1, count + 1);
            diag1[curDir1] = false;
            diag2[curDir2] = false;
        }
        whiteDfs(idx + 1, count);
    }
}

