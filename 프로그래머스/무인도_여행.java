import java.util.*;

class Solution {
    static class Node{
        int y, x;
        
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static char[][] map;
    
    static int ySize, xSize;
    public int[] solution(String[] maps) {
        ySize = maps.length;
        xSize = maps[0].length();
        
        map = new char[ySize][xSize];
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[ySize][xSize];
        
        for(int y = 0; y < ySize; y++){
            for(int x = 0; x < xSize; x++){
                map[y][x] = maps[y].charAt(x);
            }
        }
        
        for(int y = 0; y < ySize ; y++){
            for(int x = 0; x < xSize; x++){
                if(map[y][x] != 'X' && !visited[y][x]){
                    Queue<Node> que = new ArrayDeque<>();
                    que.add(new Node(y, x));
                    visited [y][x] = true;
                    int size = 0;
                    
                    while(!que.isEmpty()){
                        Node curNode = que.poll();
                        size += map[curNode.y][curNode.x] - '0';
                        
                        for(int[] dir : directions){
                            int nextY = curNode.y + dir[0];
                            int nextX = curNode.x + dir[1];
                            
                            if(nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize && 
                                !visited[nextY][nextX] && map[nextY][nextX] != 'X'){
                                visited[nextY][nextX] = true;
                                que.add(new Node(nextY, nextX));
                            }
                        }
                    }
                    
                    result.add(size);
                }
            }
        }
        
        if(result.isEmpty()){
            return new int[]{-1};
        }
        
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int idx = 0; idx < result.size(); idx++) {
            answer[idx] = result.get(idx);
        }

        return answer;
    }
}

