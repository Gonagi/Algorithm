import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map;
    static int[] parent, size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            map = new HashMap<>();
            parent = new int[200_001];
            size = new int[200_001];
            int count = 0;

            for (int idx = 0; idx <= 200_000; idx++) {
                parent[idx] = idx;
                size[idx] = 1;
            }

            int F = Integer.parseInt(br.readLine());
            for (int idx = 0; idx < F; idx++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();
                if (!map.containsKey(from)) {
                    map.put(from, count++);
                }
                if (!map.containsKey(to)) {
                    map.put(to, count++);
                }
                int fromIdx = map.get(from);
                int toIdx = map.get(to);

                union(fromIdx, toIdx);
                sb.append(size[find(fromIdx)]).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            parent[findA] = findB;
            size[findB] += size[findA];
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}

