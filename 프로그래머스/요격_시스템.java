import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int from, to;
        
        public Node(int from, int to){
            this.from = from;
            this.to = to;
        }
        
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.to, o.to);
        }
    }
    
    public int solution(int[][] targets) {
        int length = targets.length;
        Node[] nodes = new Node[length];
        for(int idx = 0; idx < length; idx++){
            nodes[idx] = new Node(targets[idx][0], targets[idx][1]);
        }
        Arrays.sort(nodes);
        
        int answer = 0;
        int last = -1;
        for(Node node : nodes){
            if(last <= node.from){
                last = node.to;
                answer++;
            }
        }
        
        return answer;
    }
}

