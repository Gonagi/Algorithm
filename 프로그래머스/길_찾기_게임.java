import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int y, x, num;
        
        public Node(int y, int x, int num){
            this.y = y;
            this.x = x;
            this.num = num;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.y == o.y){
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(o.y, this.y);
        }
    }
    
    static class Node2 {
        int x, value;
        Node2 left, right;
        
        public Node2(int x, int value){
            this.x = x;
            this.value = value;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int length = nodeinfo.length;
        Node[] nodes = new Node[length];
        
        for(int idx = 0; idx < length; idx++){
            int x = nodeinfo[idx][0];
            int y = nodeinfo[idx][1];
            nodes[idx] = new Node(y, x, idx + 1);
        }
        
        Arrays.sort(nodes);
        
        Node2 root = new Node2(nodes[0].x, nodes[0].num);
        for(int idx = 1; idx < length; idx++){
            insert(root, nodes[idx]);
        }
        
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        preorder(root, pre);
        postorder(root, post);
        
        int[][] answer = new int[2][length];
        for(int idx = 0; idx < length; idx++){
            answer[0][idx] = pre.get(idx);
            answer[1][idx] = post.get(idx);
        }
        
        return answer;
    }
    
    private void insert(Node2 parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null){
                parent.left = new Node2(child.x, child.num);
            } else{
                insert(parent.left, child);
            }
        } else{
            if(parent.right == null){
                parent.right = new Node2(child.x, child.num);
            } else{
                insert(parent.right, child);
            }
        }
    }
    
    private void preorder(Node2 node, List<Integer> list){
        if(node == null) {
            return;
        }
        list.add(node.value);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    
    private void postorder(Node2 node, List<Integer> list){
        if(node == null) {
            return;
        }
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.value);
    }
}

