import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int level;
        String name;

        public Node(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }
    }

    static class Room {
        int level;
        PriorityQueue<Node> que;

        public Room(int level, String name) {
            this.level = level;
            que = new PriorityQueue<>();
            que.add(new Node(level, name));
        }

        public void add(Node node) {
            que.add(node);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        for (int idx = 0; idx < p; idx++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (rooms.size() == 0) {
                rooms.add(new Room(level, name));
            } else {
                boolean check = false;
                for (int r = 0; r < rooms.size(); r++) {
                    if (rooms.get(r).level - 10 <= level && level <= rooms.get(r).level + 10
                            && rooms.get(r).que.size() < m) {
                        rooms.get(r).add(new Node(level, name));
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    rooms.add(new Room(level, name));
                }
            }
        }
        for (int r = 0; r < rooms.size(); r++) {
            if (rooms.get(r).que.size() == m) {
                bw.write("Started!\n");
            } else {
                bw.write("Waiting!\n");
            }
            while (!rooms.get(r).que.isEmpty()) {
                Node n = rooms.get(r).que.poll();
                bw.write(n.level + " " + n.name + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

