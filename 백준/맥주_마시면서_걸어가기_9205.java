import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Node[] inputs;
    static boolean[] visited;
    static boolean[][] canMove;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            inputs = new Node[n + 2];
            visited = new boolean[n + 2];
            canMove = new boolean[n + 2][n + 2];
            for (int idx = 0; idx < n + 2; idx++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                inputs[idx] = new Node(y, x);
            }

            for (int idx = 0; idx < n + 2; idx++) {
                for (int idx2 = idx; idx2 < n + 2; idx2++) {
                    int distance = Math.abs(inputs[idx].y - inputs[idx2].y) + Math.abs(inputs[idx].x - inputs[idx2].x);
                    if (distance != 0 && distance <= 1000) {
                        canMove[idx][idx2] = true;
                        canMove[idx2][idx] = true;
                    }
                }
            }

            Queue<Integer> que = new ArrayDeque<>();
            que.add(0);

            boolean check = false;
            while (!que.isEmpty()) {
                int cur = que.poll();
                visited[cur] = true;
                if (cur == n + 1) {
                    check = true;
                    break;
                }

                for (int idx = 0; idx < n + 2; idx++) {
                    if (!canMove[cur][idx] || cur == idx || visited[idx]) {
                        continue;
                    }
                    que.add(idx);
                    visited[idx] = true;
                }

            }
            bw.write(check ? "happy\n" : "sad\n");

        }
        bw.flush();
        br.close();
        bw.close();
    }
}

