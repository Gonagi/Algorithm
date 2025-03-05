import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, result;
    static int[] company, home, orders;
    static int[][] customers;
    static boolean[] visited;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            company = new int[2];
            home = new int[2];
            customers = new int[N][2];
            visited = new boolean[N];
            orders = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for (int idx = 0; idx < N; idx++) {
                customers[idx][0] = Integer.parseInt(st.nextToken());
                customers[idx][1] = Integer.parseInt(st.nextToken());
            }
 
            backtrack(0);
 
            bw.write("#" + testCase + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
 
    static void backtrack(int count) {
        if (count == N) {
            result = Math.min(result, cal());
            return;
        }
        for (int idx = 0; idx < N; idx++) {
            if (visited[idx]) {
                continue;
            }
            visited[idx] = true;
            orders[count] = idx;
            backtrack(count + 1);
            visited[idx] = false;
        }
    }
 
    static int cal() {
        int result = Math.abs(company[0] - customers[orders[0]][0]) + Math.abs(company[1] - customers[orders[0]][1]);
        result += Math.abs(home[0] - customers[orders[N - 1]][0]) + Math.abs(home[1] - customers[orders[N - 1]][1]);
        for (int idx = 0; idx < N - 1; idx++) {
            result += Math.abs(customers[orders[idx]][0] - customers[orders[idx + 1]][0])
                    + Math.abs(customers[orders[idx]][1] - customers[orders[idx + 1]][1]);
        }
        return result;
    }
}

