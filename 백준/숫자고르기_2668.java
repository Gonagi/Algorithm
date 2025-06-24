import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        visited = new boolean[N + 1];

        for (int idx = 1; idx <= N; idx++) {
            numbers[idx] = Integer.parseInt(br.readLine());
        }

        for (int cur = 1; cur <= N; cur++) {
            visited[cur] = true;
            DFS(cur, cur);
            visited[cur] = false;
        }

        Collections.sort(list);
        bw.write(list.size() + "\n");
        for (int result : list) {
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static private void DFS(int cur, int target) {
        if (visited[numbers[cur]] == false) {
            visited[numbers[cur]] = true;
            DFS(numbers[cur], target);
            visited[numbers[cur]] = false;
        }
        if (numbers[cur] == target) {
            list.add(target);
        }
    }
}

