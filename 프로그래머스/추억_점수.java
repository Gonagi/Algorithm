import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        
        for(int idx = 0; idx < name.length; idx++){
            map.put(name[idx], yearning[idx]);
        }
        
        for(String[] p : photo){
            int sum = 0;
            for(String n : p){
                sum += map.getOrDefault(n, 0);
            }
            list.add(sum);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
