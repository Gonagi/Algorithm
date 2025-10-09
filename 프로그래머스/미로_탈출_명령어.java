import java.util.*;

class Solution {
    static int n, m, endX, endY, k;
    static String answer;
    static int[][] directions = {{1,0},{0,-1},{0,1},{-1,0}};
    static char[] dirChar = {'d','l','r','u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.endX = r;
        this.endY = c;
        this.k = k;
        answer = null;

        dfs(x, y, 0, new StringBuilder());

        return answer == null ? "impossible" : answer;
    }

    private void dfs(int x, int y, int depth, StringBuilder sb) {
        if (!Objects.isNull(answer)){
            return;
        }

        int distance = Math.abs(endX - x) + Math.abs(endY - y);

        if (k - depth < distance || ((k - depth - distance) % 2 != 0)) {
            return;
        }

        if (depth == k) {
            if (x == endX && y == endY) {
                answer = sb.toString();
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if (nx < 1 || ny < 1 || nx > n || ny > m) {
                continue;
            }

            sb.append(dirChar[i]);
            dfs(nx, ny, depth + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

