import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int num, count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count == o.count) {
                return Integer.compare(this.num, o.num);
            }
            return Integer.compare(this.count, o.count);
        }
    }

    static int[][] A = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int y = 1; y <= 3; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= 3; x++) {
                A[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int ySize = 3;
        int xSize = 3;

        for (int time = 0; time <= 100; time++) {
            if (A[r][c] == k) {
                System.out.println(time);
                return;
            }

            if (ySize >= xSize) {
                int newXSize = 0;
                for (int y = 1; y <= ySize; y++) {
                    int[] count = new int[101];
                    for (int x = 1; x <= xSize; x++) {
                        if (A[y][x] == 0) {
                            continue;
                        }
                        count[A[y][x]]++;
                    }

                    List<Node> list = new ArrayList<>();
                    for (int idx = 1; idx <= 100; idx++) {
                        if (count[idx] > 0) {
                            list.add(new Node(idx, count[idx]));
                        }
                    }
                    Collections.sort(list);

                    for (int x = 1; x <= 100; x++) {
                        A[y][x] = 0;
                    }

                    int idx = 1;
                    for (Node node : list) {
                        if (idx > 100) {
                            break;
                        }
                        A[y][idx++] = node.num;
                        if (idx > 100) {
                            break;
                        }
                        A[y][idx++] = node.count;
                    }
                    newXSize = Math.max(newXSize, idx - 1);
                }
                xSize = Math.min(100, newXSize);
            } else {
                int newYSize = 0;
                for (int x = 1; x <= xSize; x++) {
                    int[] count = new int[101];
                    for (int y = 1; y <= ySize; y++) {
                        if (A[y][x] == 0) {
                            continue;
                        }
                        count[A[y][x]]++;
                    }

                    List<Node> list = new ArrayList<>();
                    for (int idx = 1; idx <= 100; idx++) {
                        if (count[idx] > 0) {
                            list.add(new Node(idx, count[idx]));
                        }
                    }
                    Collections.sort(list);

                    for (int y = 1; y <= 100; y++) {
                        A[y][x] = 0;
                    }

                    int idx = 1;
                    for (Node node : list) {
                        if (idx > 100) {
                            break;
                        }
                        A[idx++][x] = node.num;
                        if (idx > 100) {
                            break;
                        }
                        A[idx++][x] = node.count;
                    }
                    newYSize = Math.max(newYSize, idx - 1);
                }
                ySize = Math.min(100, newYSize);
            }
        }

        System.out.println(-1);
    }
}

