import java.io.*;
import java.util.*;
 
class Solution {
    static class Vertex implements Comparable<Vertex> {
        int no, weight;
 
        public Vertex(int no, int weight) {
            super();
            this.no = no;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
 
    static int V, E;
    static ArrayList<Vertex>[] adjMatrix;
    static boolean[] visited;
    static int[] minEdge;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adjMatrix = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjMatrix[i] = new ArrayList<>();
            }
            visited = new boolean[V];
            minEdge = new int[V];
 
            for (int idx = 0; idx < E; idx++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()) - 1;
                int B = Integer.parseInt(st.nextToken()) - 1;
                int C = Integer.parseInt(st.nextToken());
                adjMatrix[A].add(new Vertex(B, C));
                adjMatrix[B].add(new Vertex(A, C));
            }
 
            Arrays.fill(minEdge, Integer.MAX_VALUE);
            PriorityQueue<Vertex> pQUeue = new PriorityQueue<>();
 
            long result = 0, cnt = 0;
            minEdge[0] = 0;
            pQUeue.offer(new Vertex(0, minEdge[0]));
            while (!pQUeue.isEmpty()) {
                Vertex minVertex = pQUeue.poll();
                if (visited[minVertex.no]) {
                    continue;
                }
 
                result += minVertex.weight;
                visited[minVertex.no] = true;
                if (++cnt == V) {
                    break;
                }
                for (Vertex edge : adjMatrix[minVertex.no]) {
                    if (!visited[edge.no] && minEdge[edge.no] > edge.weight) {
                        minEdge[edge.no] = edge.weight;
                        pQUeue.offer(new Vertex(edge.no, edge.weight));
                    }
                }
            }
 
            bw.write("#" + testCase + " " + (cnt == V ? result : -1) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

