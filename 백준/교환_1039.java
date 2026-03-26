import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        Queue<String> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[11][1_000_001];
        que.add(N);
        visited[0][Integer.parseInt(N)] = true;

        for (int depth = 0; depth < K; depth++) {
            int size = que.size();

            for (int idx = 0; idx < size; idx++) {
                String cur = que.poll();
                char[] arr = cur.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                        if (arr[0] != '0') {
                            int next = Integer.parseInt(new String(arr));
                            if (!visited[depth + 1][next]) {
                                visited[depth + 1][next] = true;
                                que.add(String.valueOf(next));
                            }
                        }
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        int max = -1;
        while (!que.isEmpty()) {
            int value = Integer.parseInt(que.poll());
            max = Math.max(max, value);
        }

        System.out.println(max);

        br.close();
    }
}

