import java.util.*;

class Solution {
    static class Node {
        int y, x;
        
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(!(o instanceof Node)){
                return false;
            }
            Node node = (Node) o;
            return this.y == node.y && this.x == node.x;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(this.y, this.x);
        }
    }

    public String[] solution(String[] commands) {
        String[][] map = new String[51][51];
        Node[][] nodeMap = new Node[51][51];
        List<String> result = new ArrayList<>();

        for (int y = 1; y <= 50; y++) {
            for (int x = 1; x <= 50; x++) {
                map[y][x] = "EMPTY";
                nodeMap[y][x] = new Node(y, x);
            }
        }

        for (String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            String command1 = st.nextToken();

            if (command1.equals("UPDATE")) {
                String input1 = st.nextToken();

                if (st.countTokens() == 2) {
                    int r = Integer.parseInt(input1);
                    int c = Integer.parseInt(st.nextToken());
                    String value = st.nextToken();

                    for(int y = 1; y <= 50; y++){
                        for(int x = 1; x <= 50; x++){
                            if(nodeMap[y][x].equals(nodeMap[r][c])){
                                map[y][x] = value;
                            }
                        }
                    }
                } else {
                    String input2 = st.nextToken();
                    for (int y = 1; y <= 50; y++) {
                        for (int x = 1; x <= 50; x++) {
                            if (map[y][x].equals(input1)) {
                                map[y][x] = input2;
                            }
                        }
                    }
                }

            } else if (command1.equals("MERGE")) {
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());

                Node node1 = nodeMap[r1][c1];
                Node node2 = nodeMap[r2][c2];
                if (node1.equals(node2)) {
                    continue;
                }
                
                String value = map[node1.y][node1.x].equals("EMPTY") ? map[node2.y][node2.x] : map[node1.y][node1.x];
                
                for (int y = 1; y <= 50; y++) {
                    for (int x = 1; x <= 50; x++) {
                        if(nodeMap[y][x].equals(node2)) {
                                nodeMap[y][x] = node1;
                        }
                    }
                } 
                for (int y = 1; y <= 50; y++) {
                    for (int x = 1; x <= 50; x++) {
                        if(nodeMap[y][x].equals(node1)){
                                map[y][x] = value;
                        }
                    }
                }
            } else if (command1.equals("UNMERGE")) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                Node node = nodeMap[r][c];
                String curValue = map[r][c];
                for(int y = 1; y <= 50; y++){
                    for(int x = 1; x <= 50; x++){
                        if(nodeMap[y][x].equals(node)){
                            nodeMap[y][x] = new Node(y, x);
                            map[y][x] = "EMPTY";
                        }
                    }
                }
                
                map[r][c] = curValue;
            } else if (command1.equals("PRINT")) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                Node node = nodeMap[r][c];
                String value = map[node.y][node.x];
                result.add(value);
            }
        }

        return result.toArray(new String[0]);
    }
}

