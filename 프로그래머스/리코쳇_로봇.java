import java.util.*;

class Solution {
    static class Node {
        int y, x, count;
        
        public Node(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public int solution(String[] board) {
        int ySize = board.length;
        int xSize = board[0].length();
        
        Queue<Node> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[ySize][xSize];
        char[][] map = new char[ySize][xSize];
        for(int y = 0; y < ySize; y++){
            for(int x = 0; x < xSize; x++){
                map[y][x] = board[y].charAt(x);
                if(map[y][x] == 'R'){
                    que.add(new Node(y, x, 0));
                    visited[y][x] = true;
                }
            }
        }
        
        while(!que.isEmpty()){
            Node curNode = que.poll();
            if(map[curNode.y][curNode.x] == 'G'){
                return curNode.count;
            }
            
            for(int[] dir : directions) {
                int nextY = curNode.y;
                int nextX = curNode.x;
                while(nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize &&
                      map[nextY][nextX] != 'D'){
                    nextY += dir[0];
                    nextX += dir[1];
                }
                
                nextY -= dir[0];
                nextX -= dir[1];
                
                if(!visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    que.add(new Node(nextY, nextX, curNode.count + 1));
                }
            }
        }
        
        return -1;
    }
}

