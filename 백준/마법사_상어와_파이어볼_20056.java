import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int m, s, d;

        public Node(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static List<Node>[][] map;
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                map[y][x] = new ArrayList<>();
            }
        }

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new Node(m, s, d));
        }

        for (int idx = 0; idx < K; idx++) {
            List<Node>[][] newMap = new ArrayList[N + 1][N + 1];
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    newMap[y][x] = new ArrayList<>();
                }
            }

            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    for (Node curNode : map[y][x]) {
                        int nextY = (y + directions[curNode.d][0] * curNode.s) % N;
                        int nextX = (x + directions[curNode.d][1] * curNode.s) % N;
                        if (nextY <= 0) {
                            nextY += N;
                        }
                        if (nextX <= 0) {
                            nextX += N;
                        }
                        newMap[nextY][nextX].add(curNode);
                    }
                }
            }
            map = newMap;

            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    if (map[y][x].size() >= 2) {
                        int sumM = 0, sumS = 0;
                        boolean even = true, odd = true;

                        for (Node curNode : map[y][x]) {
                            sumM += curNode.m;
                            sumS += curNode.s;
                            if (curNode.d % 2 == 0) {
                                odd = false;
                            } else {
                                even = false;
                            }
                        }

                        int newM = sumM / 5;
                        int newS = sumS / map[y][x].size();
                        map[y][x].clear();

                        if (newM == 0) {
                            continue;
                        }

                        if (even || odd) {
                            for (int nextDir = 0; nextDir < 8; nextDir += 2) {
                                Node nextNode = new Node(newM, newS, nextDir);
                                map[y][x].add(nextNode);
                            }
                        } else {
                            for (int nextDir = 1; nextDir < 8; nextDir += 2) {
                                Node nextNode = new Node(newM, newS, nextDir);
                                map[y][x].add(nextNode);
                            }
                        }
                    }
                }
            }
        }

        int sum = 0;
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (!map[y][x].isEmpty()) {
                    for (Node node : map[y][x]) {
                        sum += node.m;
                    }
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}

