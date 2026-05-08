import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());        
        Collections.sort(list, Collections.reverseOrder());
        
        int result = 0;
        for(Integer count : list){
            k -= count;
            result++;
            if(k <= 0){
                break;
            }
        }
        
        return result;
    }
}

