import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        String name;
        int korean, english, math;

        public Node(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Node o) {
            if (this.korean != o.korean) {
                return Integer.compare(o.korean, this.korean);
            }

            if (this.english != o.english) {
                return Integer.compare(this.english, o.english);
            }

            if (this.math != o.math) {
                return Integer.compare(o.math, this.math);
            }

            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            nodes[idx] = new Node(name, korean, english, math);
        }

        Arrays.sort(nodes);
        for (Node node : nodes) {
            bw.write(node.name);
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

