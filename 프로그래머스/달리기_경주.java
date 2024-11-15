import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String player : players) {
            map.put(player, index);
            index++;
        }

        for (String calling : callings) {
            int changeIndex = map.get(calling);
            String temp = players[changeIndex];

            players[changeIndex] = players[changeIndex - 1];
            map.put(calling, changeIndex - 1);

            players[changeIndex - 1] = temp;
            map.put(players[changeIndex], changeIndex);
        }

        return players;
    }
}