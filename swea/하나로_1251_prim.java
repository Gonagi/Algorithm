import java.io.*;
import java.util.*;
 
class Solution {
    static class Vertex implements Comparable<Vertex> {
        int no;
        double weight;
 
        public Vertex(int no, double weight) {
            super();
            this.no = no;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Vertex o) {
            return Double.compare(this.weight, o.weight);
        }
    }
 
    static int N;
    static Double E;
    static ArrayList<Vertex>[] adjMatrix;
    static boolean[] visited;
    static double[] minEdge;
    static int[] xs, ys;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer xInput = new StringTokenizer(br.readLine());
            StringTokenizer yInput = new StringTokenizer(br.readLine());
            E = Double.parseDouble(br.readLine());
 
            adjMatrix = new ArrayList[N];
            for (int idx = 0; idx < N; idx++) {
                adjMatrix[idx] = new ArrayList<>();
            }
            visited = new boolean[N];
            minEdge = new double[N];
            Arrays.fill(minEdge, Double.MAX_VALUE);
            xs = new int[N];
            ys = new int[N];
 
            for (int idx = 0; idx < N; idx++) {
                int x = Integer.parseInt(xInput.nextToken());
                int y = Integer.parseInt(yInput.nextToken());
                xs[idx] = x;
                ys[idx] = y;
            }
 
            dfs(0, 0, new int[2]);
 
            double result = 0.0;
            int cnt = 0;
            PriorityQueue<Vertex> que = new PriorityQueue<>();
 
            minEdge[0] = 0;
            que.add(new Vertex(0, minEdge[0]));
 
            while (!que.isEmpty()) {
                Vertex curVertex = que.poll();
                if (visited[curVertex.no]) {
                    continue;
                }
                result += curVertex.weight;
                visited[curVertex.no] = true;
                if (++cnt == N) {
                    break;
                }
 
                for (Vertex v : adjMatrix[curVertex.no]) {
                    if (visited[v.no]) {
                        continue;
                    }
                    if (minEdge[v.no] > v.weight) {
                        minEdge[v.no] = v.weight;
                        que.offer(new Vertex(v.no, v.weight));
                    }
                }
            }
            long answer = Math.round(result);
            bw.write("#" + testCase + " " + (cnt == N ? answer : -1) + "\n");
            bw.flush();
 
        }
        br.close();
        bw.close();
    }
 
    static void dfs(int start, int count, int[] pair) {
        if (count == 2) {
            int from = pair[0];
            int to = pair[1];
            long yDistance = Math.abs(ys[from] - ys[to]);
            long xDistance = Math.abs(xs[from] - xs[to]);
            double weight = (yDistance * yDistance + xDistance * xDistance) * E;
            adjMatrix[from].add(new Vertex(to, weight));
            adjMatrix[to].add(new Vertex(from, weight));
            return;
        }
        for (int idx = start; idx < N; idx++) {
            pair[count] = idx;
            dfs(idx + 1, count + 1, pair);
        }
    }
}

