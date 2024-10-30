import java.util.*;

class Solution {
    Integer[][] giftTable;
    List<Integer> jisu;
    Map<String, Integer> friendIndexMap;

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendCount = friends.length;

        friendIndexMap = mapFriendIndices(friends);
        giftTable = createGiftTable(friendCount);

        jisu = new ArrayList<>(Collections.nCopies(friendCount, 0));
        processGift(friends, gifts);

        calculateJisu(friendCount);
        answer = calculateResult(friendCount);

        return answer;
    }

    private Map<String, Integer> mapFriendIndices(String[] friends) {
        Map<String, Integer> map = new HashMap<>();

        for (int idx = 0; idx < friends.length; idx++) {
            map.put(friends[idx], idx);
        }

        return map;
    }

    private Integer[][] createGiftTable(int friendCount) {
        Integer[][] table = new Integer[friendCount][friendCount];

        for (Integer[] row : table) {
            Arrays.fill(row, 0);
        }

        return table;
    }

    private void processGift(String[] friends, String[] gifts) {
        int from, to;
        String[] persons;

        for (String gift : gifts) {
            persons = gift.split(" ");
            from = friendIndexMap.get(persons[0]);
            to = friendIndexMap.get(persons[1]);

            giftTable[from][to] += 1;
        }
    }

    private void calculateJisu(int friendCount) {
        for (int y = 0; y < friendCount; y++) {
            int giveCount = Arrays.stream(giftTable[y])
                    .mapToInt(Integer::intValue)
                    .sum();
            int receiveCount = 0;
            for (int x = 0; x < friendCount; x++) {
                receiveCount += giftTable[x][y];
            }
            jisu.set(y, giveCount - receiveCount);
        }
    }

    private int calculateResult(int friendCount) {
        List<Integer> nextMonthGifts = new ArrayList<>(Collections.nCopies(friendCount, 0));

        for (int y = 0; y < friendCount; y++) {
            for (int x = y + 1; x < friendCount; x++) {
                if (giftTable[y][x] < giftTable[x][y]) {
                    nextMonthGifts.set(x, nextMonthGifts.get(x) + 1);
                } else if (giftTable[y][x] > giftTable[x][y]) {
                    nextMonthGifts.set(y, nextMonthGifts.get(y) + 1);
                } else {
                    if (jisu.get(x) > jisu.get(y)) {
                        nextMonthGifts.set(x, nextMonthGifts.get(x) + 1);
                    } else if (jisu.get(x) < jisu.get(y)) {
                        nextMonthGifts.set(y, nextMonthGifts.get(y) + 1);
                    }
                }
            }
        }
        return Collections.max(nextMonthGifts);
    }
}