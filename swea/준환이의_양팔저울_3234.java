import java.util.*;
import java.io.*;
 
class Solution
{
    static int count;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N + 1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            for (int idx = 1; idx <= N; idx++) {
                num[idx] = Integer.parseInt(st.nextToken());
            }
 
            Arrays.sort(num);
 
            check(0, 0, 0, new boolean[N + 1], num, N);
            bw.write(String.format("#%d %d", testCase, count));
            bw.newLine();
 
        }
        bw.flush();
        br.close();
        bw.close();
    }
 
    private static void check(int depth, int left, int right, boolean[] visited, int[] num, int N) {
        if (depth == N) {
            count++;
            return;
        }
        for (int cur = 1; cur <= N; cur++) {
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            check(depth + 1, left + num[cur], right, visited, num, N);
            if (right + num[cur] <= left) {
                check(depth + 1, left, right + num[cur], visited, num, N);
            }
            visited[cur] = false;
        }
    }
}
