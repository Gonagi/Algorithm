import java.io.*;

public class Main {
    static int[] parent;
    static int G, P;
    static boolean isResult = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        G = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int idx = 1; idx <= G; idx++) {
            parent[idx] = idx;
        }

        P = Integer.parseInt(br.readLine());
        int count = 0;
        for (int idx = 0; idx < P; idx++) {
            int p = Integer.parseInt(br.readLine());
            int emptyGate = find(p);

            if (emptyGate == 0) {
                break;
            }

            count++;
            union(p, emptyGate - 1);
        }

        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int fX = find(x);
        int fY = find(y);
        parent[fX] = fY;
    }
}

