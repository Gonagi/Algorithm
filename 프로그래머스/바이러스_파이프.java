import java.util.*;

class Solution {
    static class Node{
        int to;
        char type;
        
        public Node(int to, char type){
            this.to = to;
            this.type = type;
        }
    }
    
    static List<Node>[] graph;
    static int n, k, infection, max = -1;
    static char[] order;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.infection = infection;
        this.k = k;
        graph = new ArrayList[n + 1];
        for(int idx = 1; idx <= n; idx++){
            graph[idx] = new ArrayList<>();
        }
        order = new char[k];
        
        for(int idx = 0; idx < n-1; idx++){
            int from = edges[idx][0];
            int to = edges[idx][1];
            char type = edges[idx][2] == 1 ? 'A' : edges[idx][2] == 2 ? 'B' : 'C';
            graph[from].add(new Node(to, type));
            graph[to].add(new Node(from, type));
        }
        
        dfs(0);
        return max;
    }
    
    private static void dfs(int count){
        if(count == k){
            int cal = bfs();
            max = Math.max(max, cal);
            return;
        }
        
        order[count] = 'A';
        dfs(count + 1);
        order[count] = 'B';
        dfs(count + 1);
        order[count] = 'C';
        dfs(count + 1);
    }
    
    private static int bfs(){
        boolean[] check = new boolean[n + 1];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(infection);
        check[infection] = true;
        
        for(int curIdx = 0; curIdx < k; curIdx++) {
            Queue<Integer> nextQue = new ArrayDeque<>();
            while(!que.isEmpty()){
                int cur = que.poll();
                for(Node nextNode : graph[cur]){
                    if(check[nextNode.to]){
                        continue;
                    }
                    if(nextNode.type != order[curIdx]){
                        continue;
                    }
                    que.add(nextNode.to);
                    nextQue.add(nextNode.to);
                    check[nextNode.to] = true;
                }
                nextQue.add(cur);
            }
            que = nextQue;
        }
        
        int result = 0;
        for(boolean c : check){
            if(c){
                result++;
            }
        }
        
        return result;
    }
}

