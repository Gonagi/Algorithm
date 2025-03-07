// BFS
import java.io.*;
import java.util.*;
 
public class Solution {
    static int V, E;
    static boolean[][] edges;
    static int[] edgeReverseCounts;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int testCase = 1; testCase <= 10; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edges = new boolean[V + 1][V + 1];
            edgeReverseCounts = new int[V + 1];
 
            st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < E; idx++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edges[from][to] = true;
                edgeReverseCounts[to]++;
            }
 
            Queue<Integer> que = new ArrayDeque<>();
            for (int node = 1; node <= V; node++) {
                if (edgeReverseCounts[node] == 0) {
                    que.add(node);
                }
            }
 
            bw.write("#" + testCase + " ");
            while (!que.isEmpty()) {
                int curNode = que.poll();
                bw.write(curNode + " ");
                for (int nextNode = 1; nextNode <= V; nextNode++) {
                    if (edges[curNode][nextNode]) {
                        edgeReverseCounts[nextNode]--;
                        if (edgeReverseCounts[nextNode] == 0) {
                            que.add(nextNode);
                        }
                    }
                }
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

// DFS
import java.io.*;
import java.util.*;
 
public class Solution {
    static int V, E;
    static boolean[][] edges;
    static boolean[] visited;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int testCase = 1; testCase <= 10; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edges = new boolean[V + 1][V + 1];
            visited = new boolean[V + 1];
 
            st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < E; idx++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edges[to][from] = true;
            }
            bw.write("#" + testCase + " ");
            for (int node = 1; node <= V; node++) {
                if (!visited[node]) {
                    dfs(node, bw);
                }
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
 
    static void dfs(int curNode, BufferedWriter bw) throws Exception {
        visited[curNode] = true;
 
        for (int prevNode = 1; prevNode <= V; prevNode++) {
            if (edges[curNode][prevNode] && !visited[prevNode]) {
                dfs(prevNode, bw);
            }
        }
        bw.write(curNode + " ");
    }
}

