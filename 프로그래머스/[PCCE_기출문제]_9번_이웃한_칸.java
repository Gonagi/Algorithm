class Solution {
    private Direction[] dir = { new Direction(1, 0), new Direction(-1, 0),
            new Direction(0, 1), new Direction(0, -1) };
    private int n;

    public int solution(String[][] board, int h, int w) {
        n = board.length;
        int answer = 0;
        String color = board[h][w];

        for (int d = 0; d < 4; d++) {
            Direction next = new Direction(h + dir[d].getY(), w + dir[d].getX());
            if (canMove(next)) {
                if (color.equals(board[next.getY()][next.getX()])) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean canMove(Direction next) {
        if (next.getY() < 0 || next.getY() >= n || next.getX() < 0 || next.getX() >= n)
            return false;
        return true;
    }

    static class Direction {
        private int y;
        private int x;

        public Direction(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

}
