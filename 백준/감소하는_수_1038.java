import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int num = 0; num <= 9; num++) {
            dfs(num, num);
        }

        Collections.sort(list);
        if (N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
        br.close();
    }

    private static void dfs(long num, int last) {
        list.add(num);

        for (int next = 0; next < last; next++) {
            dfs(num * 10 + next, next);
        }
    }
}

