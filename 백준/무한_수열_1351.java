import java.io.*;
import java.util.*;

public class Main {
    static long P, Q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);

        System.out.println(dfs(N));
    }

    static long dfs(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        long value = dfs(n / P) + dfs(n / Q);
        map.put(n, value);
        return value;
    }
}

