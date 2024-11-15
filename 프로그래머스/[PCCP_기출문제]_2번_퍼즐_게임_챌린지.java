import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();
        int level = 0;

        while (start <= end) {
            level = (start + end) / 2;
            long time = getTime(diffs, times, level);
            if (time <= limit) {
                answer = level;
                end = level - 1;
            } else {
                start = level + 1;
            }
        }
        return answer;
    }

    private long getTime(int[] diffs, int[] times, int level) {
        long time = 0;
        int prev = 0;

        for (int cur = 0; cur < diffs.length; cur++) {
            if (diffs[cur] <= level) {
                time += times[cur];
            } else {
                time += (times[cur] + prev) * (diffs[cur] - level) + times[cur];
            }
            prev = times[cur];
        }
        return time;
    }
}