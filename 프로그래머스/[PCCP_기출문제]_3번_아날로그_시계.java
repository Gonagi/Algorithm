import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        double hAngle = ((h1 % 12) * 30) + (m1 / 2.0) + (s1 / 120.0);
        double mAngle = (m1 * 6) + (s1 / 10.0);
        double sAngle = s1 * 6;

        long startTime = h1 * 3600 + m1 * 60 + s1;
        long endTime = h2 * 3600 + m2 * 60 + s2;
        int answer = 0;

        for (int idx = 0; idx < endTime - startTime; idx++) {
            double nextHAngle = (hAngle + 1.0 / 120);
            double nextMAngle = (mAngle + 1.0 / 10);
            double nextSAngle = (sAngle + 6);

            if (hAngle == sAngle) {
                answer++;
            } else if (mAngle == sAngle) {
                answer++;
            }

            else {
                boolean check = false;
                if (Double.compare(mAngle, sAngle) > 0 &&
                        Double.compare(nextMAngle, nextSAngle) <= 0) {
                    answer++;
                }
                if (Double.compare(hAngle, sAngle) > 0 &&
                        Double.compare(nextHAngle, nextSAngle) <= 0) {
                    answer++;
                }
                if (Double.compare(mAngle, hAngle) < 0 && Double.compare(sAngle, hAngle) < 0 &&
                        Double.compare(nextMAngle, nextHAngle) >= 0 && Double.compare(nextSAngle, nextHAngle) >= 0) {
                    answer--;
                }
            }
            hAngle = nextHAngle >= 360 ? 0 : nextHAngle;
            mAngle = nextMAngle >= 360 ? 0 : nextMAngle;
            sAngle = nextSAngle >= 360 ? 0 : nextSAngle;
        }

        if (hAngle == 0 && sAngle == 0) {
            answer++;
        } else if (mAngle == 0 && sAngle == 0) {
            answer++;
        }

        return answer;
    }
}