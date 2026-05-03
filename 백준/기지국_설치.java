import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1;
        
        int start = 1;
        
        for(int station : stations){
            int left = station - w;
            int right = station + w;
            
            if(start < left){
                int length = left - start;
                answer += (length + range - 1) / range;
            }
            
            start = right + 1;
        }
        
        if(start <= n){
            int length = n - start + 1;
            answer += (length + range - 1) / range;
        }
        return answer;
    }
}

