import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Integer[] reverseMats = sortMatsReverse(mats);

        for (Integer matSize : reverseMats) {
            int result = checkParkLocation(park, matSize);
            if (result > -1) {
                return result;
            }
        }
        return -1;
    }

    int checkParkLocation(String[][] park, int matSize) {
        for (int y = 0; y <= park.length - matSize; y++) {
            for (int x = 0; x <= park[0].length - matSize; x++) {
                if (park[y][x].equals("-1") && checkMats(park, matSize, y, x)) {
                    return matSize;
                }
            }
        }

        return -1;
    }

    public boolean checkMats(String[][] park, int matSize, int y, int x) {
        for (int checkY = y; checkY < y + matSize; checkY++) {
            for (int checkX = x; checkX < x + matSize; checkX++) {
                if (!park[checkY][checkX].equals("-1"))
                    return false;
            }
        }
        return true;
    }

    public Integer[] sortMatsReverse(final int[] mats) {
        Integer[] matsInteger = Arrays.stream(mats)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(matsInteger, Collections.reverseOrder());

        return matsInteger;
    }
}