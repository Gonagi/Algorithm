import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {        
        StringBuilder sb = new StringBuilder(message);
        for(int[] range : spoiler_ranges){
            for(int idx = range[0]; idx <= range[1]; idx++){
                if(sb.charAt(idx) != ' '){
                    sb.setCharAt(idx, '*');
                }
            }
        }
        
        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(sb.toString());
        while(st.hasMoreTokens()){
            set.add(st.nextToken());
        }
        
        int answer = 0;
        st = new StringTokenizer(message);
        while(st.hasMoreTokens()){
            String word = st.nextToken();
            if(!set.contains(word)){
                set.add(word);
                answer++;
            }
        }
        
        return answer;
    }
}
