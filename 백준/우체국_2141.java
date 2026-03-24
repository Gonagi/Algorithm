import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        long people;

        public Node(int x, long people) {
            this.x = x;
            this.people = people;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N];
        long total = 0;
        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            arr[idx] = new Node(x, a);
            total += a;
        }
        br.close();

        Arrays.sort(arr);

        long sum = 0;
        for (Node n : arr) {
            sum += n.people;
            if (sum >= (total + 1) / 2) {
                System.out.println(n.x);
                return;
            }
        }
    }
}

