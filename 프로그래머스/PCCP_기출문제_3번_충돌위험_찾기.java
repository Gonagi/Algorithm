import java.util.*;

class Solution {
    static Set<Log> logs = new HashSet<>();
    static Set<Log> check = new HashSet<>();
    
    public static int solution(int[][] points, int[][] routes) {
        for (int[] route : routes) {
            int time = 1;
            Direction start = new Direction(points[route[0] - 1][0], points[route[0] - 1][1]);

            if (!logs.add(new Log(new Direction(start.y, start.x), time))) {
                check.add(new Log(new Direction(start.y, start.x), time));
            }
            time++;
            
            for (int idx = 0; idx < route.length - 1; idx++) {
                Direction next = new Direction(points[route[idx + 1] - 1][0], points[route[idx + 1] - 1][1]);

                 while (start.y != next.y) {
                    start.y += (start.y > next.y) ? -1 : 1;
                    Log log = new Log(new Direction(start.y, start.x), time);
                    if (!logs.add(log)) {
                        check.add(log);
                    }
                    time++;
                }

                while (start.x != next.x) {
                    start.x += (start.x > next.x) ? -1 : 1;
                    Log log = new Log(new Direction(start.y, start.x), time);
                    if (!logs.add(log)) {
                        check.add(log);
                    }
                    time++;
                }
            }
        }
        return check.size();
    }

    static class Log {
        Direction dir;
        int time;

        Log(Direction dir, int time) {
            this.dir = dir;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Log log = (Log) o;
            return dir.equals(log.dir) && time == log.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dir, time);
        }
    }

    static class Direction {
        int y, x;

        Direction(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Direction dir = (Direction) o;
            return this.y == dir.y && this.x == dir.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
