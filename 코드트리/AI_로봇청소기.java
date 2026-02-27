import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int y, x;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Node o){
            if(this.y  == o.y){
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }
    }

    static int N, K, L;
    static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int[][] map;
    static boolean[][] vaccumMap;
    static Queue<Node> que;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        vaccumMap = new boolean[N + 1][N + 1];

        for(int y = 1; y <= N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= N; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        que = new ArrayDeque<>();
        for(int idx = 0; idx < K; idx++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            que.add(new Node(y, x));
            vaccumMap[y][x] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int l = 0; l < L; l++){
            int queSize = que.size();
            for(int q = 0; q < queSize; q++){
                move();
            }

            for(int q = 0; q < queSize; q++){
                clean();
            }

            for(int y = 1; y <= N; y++){
                for(int x = 1; x <= N; x++){
                    if(map[y][x] > 0){
                        map[y][x] += 5;
                    }
                }
            }
            spread();

            int sum = 0;
            for(int y = 1; y <= N; y++){
                for(int x = 1; x <= N; x++){
                    if(map[y][x] > 0){
                        sum += map[y][x];
                    }
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static void spread(){
        int[][] newMap = new int[N + 1][N + 1];

        for(int y = 1; y <= N; y++){
            for(int x = 1; x <= N; x++){
                if(map[y][x] == -1){
                    newMap[y][x] = -1;
                } else if(map[y][x] == 0){
                    int sum = 0;
                    for(int[] dir : directions){
                        int nextY = y + dir[0];
                        int nextX = x + dir[1];
                        if(canMove(nextY, nextX) && map[nextY][nextX] != -1){ 
                            sum += map[nextY][nextX];
                        }
                    }
                    newMap[y][x] = sum / 10;
                } else{
                    newMap[y][x] = map[y][x];
                }
            }
        }

        map = newMap;
    }

    private static void clean(){
        Node node = que.poll();
        int maxDir = -1;
        int maxSum = -1;

        int[] priority = {0, 1, 2, 3};

        for(int dir : priority) {
            int sum = 0;
            sum += Math.min(20, map[node.y][node.x]);

            int upDir = dir;
            int nextY = node.y + directions[upDir][0];
            int nextX = node.x + directions[upDir][1];
            if(canMove(nextY, nextX) && map[nextY][nextX] != -1){
                sum += Math.min(20, map[nextY][nextX]);
            }

            int leftDir = (dir + 3) % 4;
            nextY = node.y + directions[leftDir][0];
            nextX = node.x + directions[leftDir][1];
            if(canMove(nextY, nextX) && map[nextY][nextX] != -1){
                sum += Math.min(20, map[nextY][nextX]);
            }

            int rightDir = (dir + 1) % 4;
            nextY = node.y + directions[rightDir][0];
            nextX = node.x + directions[rightDir][1];
            if(canMove(nextY, nextX) && map[nextY][nextX] != -1){
                sum += Math.min(20, map[nextY][nextX]);
            }

            if(maxSum < sum){
                maxSum = sum;
                maxDir = dir;
            }
        }

        map[node.y][node.x] -= Math.min(20, map[node.y][node.x]);

        int upDir = maxDir;
        int nextY = node.y + directions[upDir][0];
        int nextX = node.x + directions[upDir][1];
        if(canMove(nextY, nextX) && map[nextY][nextX] != -1){
            map[nextY][nextX] -= Math.min(20, map[nextY][nextX]);
        }

        int leftDir = (maxDir + 3) % 4;
        nextY = node.y + directions[leftDir][0];
        nextX = node.x + directions[leftDir][1];
        if(canMove(nextY, nextX) && map[nextY][nextX] != -1){
            map[nextY][nextX] -= Math.min(20, map[nextY][nextX]);
        }

        int rightDir = (maxDir + 1) % 4;
        nextY = node.y + directions[rightDir][0];
        nextX = node.x + directions[rightDir][1];
        if(canMove(nextY, nextX) && map[nextY][nextX] != -1){
            map[nextY][nextX] -= Math.min(20, map[nextY][nextX]);
        }

        que.add(node);
    }

    private static void move(){
        Node node = que.poll();
        if(map[node.y][node.x] > 0){
            que.add(node);
            return;
        }
        boolean[][] visited = new boolean[N + 1][N + 1];

        Queue<Node> curQue = new ArrayDeque<>();
        curQue.add(node);
        visited[node.y][node.x] = true;
        while(!curQue.isEmpty()){
            int queSize = curQue.size();
            List<Node> candidates = new ArrayList<>();

            for(int q = 0; q < queSize; q++){
                Node curNode = curQue.poll();
                for(int[] dir : directions){
                    int nextY = curNode.y + dir[0];
                    int nextX = curNode.x + dir[1];
                    if(canMove(nextY, nextX) && !visited[nextY][nextX] &&
                        map[nextY][nextX] != -1 && !vaccumMap[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        if(map[nextY][nextX] > 0){
                            candidates.add(new Node(nextY, nextX));
                        }else {
                            curQue.add(new Node(nextY, nextX));
                        }
                    }
                }
            }

            if(!candidates.isEmpty()){
                Collections.sort(candidates);
                Node curNode = candidates.get(0);

                vaccumMap[node.y][node.x] = false;
                vaccumMap[curNode.y][curNode.x] = true;
                que.add(curNode);
                return;
            }
        }
        que.add(node);
    }

    private static boolean canMove(int y, int x){
        return y >= 1 && y <= N && x >= 1 && x <= N;
    }
}
