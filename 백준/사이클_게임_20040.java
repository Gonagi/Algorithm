import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int idx = 0; idx < n; idx++) {
            parent[idx] = idx;
        }
        boolean check = false;
        for (int idx = 1; idx <= m; idx++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            if (find(node1) == find(node2)) {
                bw.write(String.valueOf(idx));
                check = true;
                break;
            }
            union(node1, node2);
        }

        if (!check) {
            bw.write("0");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int find(int x) {
        if (x != parent[x]) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int fX = find(x);
        int fY = find(y);

        if (fX != fY) {
            parent[fX] = fY;
        }
    }
}

