import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int weight, height;

        public Node(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Node[] people = new Node[N];

        for (int idx = 0; idx < N; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people[idx] = new Node(x, y);
        }

        for (int idx = 0; idx < N; idx++) {
            int rank = 1;
            for (int idx2 = 0; idx2 < N; idx2++) {
                if (people[idx].weight < people[idx2].weight &&
                        people[idx].height < people[idx2].height) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}

