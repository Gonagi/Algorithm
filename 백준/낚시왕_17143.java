import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, s, d, z;

        public Node(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int[][] directions = {{0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int R, C, M;
    static Node[][] map;
    static List<Node> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int result = 0;
        map = new Node[R + 1][C + 1];
        list = new ArrayList<>();

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            Node node = new Node(r, c, s, d, z);
            map[r][c] = node;
            list.add(node);
        }

        for (int idx = 1; idx <= C; idx++) {
            for (int y = 1; y <= R; y++) {
                if (map[y][idx] != null) {
                    Node caught = map[y][idx];
                    result += caught.z;
                    list.remove(caught);
                    map[y][idx] = null;
                    break;
                }
            }

            for (Node node : list) {
                move(node);
            }

            rebuildMap();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void move(Node node) {
        int move = node.s;

        if (node.d == 1 || node.d == 2) {
            move %= (R - 1) * 2;
        } else {
            move %= (C - 1) * 2;
        }

        int nextY = node.r;
        int nextX = node.c;
        for (int idx = 0; idx < move; idx++) {
            nextY += directions[node.d][0];
            nextX += directions[node.d][1];

            if (nextY <= 0 || nextY > R) {
                node.d = node.d == 1 ? 2 : 1;
                nextY += (directions[node.d][0] * 2);

            } else if (nextX <= 0 || nextX > C) {
                node.d = node.d == 3 ? 4 : 3;
                nextX += (directions[node.d][1] * 2);
            }
        }
        node.r = nextY;
        node.c = nextX;
    }

    private static void rebuildMap() {
        Node[][] newMap = new Node[R + 1][C + 1];
        List<Node> newList = new ArrayList<>();

        for (Node node : list) {
            if (newMap[node.r][node.c] == null) {
                newMap[node.r][node.c] = node;
                newList.add(node);
            } else {
                if (newMap[node.r][node.c].z < node.z) {
                    newList.remove(newMap[node.r][node.c]);
                    newMap[node.r][node.c] = node;
                    newList.add(node);
                }
            }
        }

        map = newMap;
        list = newList;
    }
}

