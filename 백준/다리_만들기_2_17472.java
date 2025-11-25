atic int N, M, num;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        newMap = new int[N][M];
        visited = new boolean[N][M];
        
        for(int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        
        num = 1;
  import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    static class Node{
        int y, x;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static class Node2 implements Comparable<Node2> {
        int from, to, value;

        public Node2(int from, int to, int value){
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node2 o) {
            return Integer.compare(this.value, o.value);
        }
    }
    
    static int[][] map;
    static int[][] newMap;
    static boolean[][] visited;
    static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[] parent;
    st      for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                if(map[y][x] == 1 && !visited[y][x]){
                    bfs(y, x);
                    num++;
                }
            }
        }

        List<Node>[] list = new ArrayList[num];
        List<Node2> result = new ArrayList<>();
        
        for(int idx = 0; idx < num; idx++){
            list[idx] = new ArrayList<>();
        }

        for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                int island = newMap[y][x];
                list[island].add(new Node(y, x));
            }
        }

        for(int idx = 1; idx < num - 1; idx++){
            for(int idx2 = idx + 1; idx2 < num; idx2++){
                for(int idx3 = 0; idx3 < list[idx].size(); idx3++){
                    for(int idx4 = 0; idx4 < list[idx2].size(); idx4++){
                        Node node1 = list[idx].get(idx3);
                        Node node2 = list[idx2].get(idx4);
                        if(node1.y == node2.y){
                            if(Math.abs(node1.x - node2.x) > 2 && checkBetween('y', node1.y, node1.x, node2.x)) {
                                result.add(new Node2(idx, idx2, Math.abs(node1.x - node2.x) -1));
                            }
                        } else if(node1.x == node2.x) {
                            if(Math.abs(node1.y - node2.y) > 2 && checkBetween('x', node1.x, node1.y, node2.y)) {
                                result.add(new Node2(idx, idx2, Math.abs(node1.y - node2.y) -1));
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(result);
        parent = new int[num];
        for(int idx = 1; idx < num; idx++){
            parent[idx] = idx;
        }

        int used = 0;
        int sum = 0;
        int islandCount = num - 1;

        for(Node2 node2 : result) {
            if(union(node2.from, node2.to)) {
                sum += node2.value;
                used++;
            }
        }

        if(used == islandCount -1) {
            bw.write(String.valueOf(sum));
        } else {
            bw.write("-1");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static boolean union(int x, int y) {
        int fX = find(x);
        int fY = find(y);

        if(fX == fY) {
            return false;
        }
        parent[fX] = fY;
        return true;
    }
    
    private static boolean checkBetween(char ch, int standard, int from, int to){
        if(ch == 'y') {
            if(from > to){
                for(int idx = to + 1; idx < from; idx++){
                    if(newMap[standard][idx] != 0){
                        return false;
                    }
                }
            } else {
                for(int idx = from + 1; idx < to; idx++){
                    if(newMap[standard][idx] != 0){
                        return false;
                    }
                }
            }
        } else if(ch == 'x') {
            if(from > to){
                for(int idx = to + 1; idx < from; idx++){
                    if(newMap[idx][standard] != 0){
                        return false;
                    }
                }
            } else {
                for(int idx = from + 1; idx < to; idx++){
                    if(newMap[idx][standard] != 0){
                        return false;
                    }
                }
            }
        }
        return true;    
    }

    private static void bfs(int y, int x){
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(y, x));
        
        while(!que.isEmpty()){
            Node curNode = que.poll();
            visited[curNode.y][curNode.x] = true;
            newMap[curNode.y][curNode.x] = num;
            
            for(int[] dir: directions){
                int nextY = curNode.y + dir[0];
                int nextX = curNode.x + dir[1];
                if(canMove(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] == 1){
                    visited[nextY][nextX] = true;
                    que.add(new Node(nextY, nextX));
                }
            }
        }
    }
    
    private static boolean canMove(int y, int x){
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}

