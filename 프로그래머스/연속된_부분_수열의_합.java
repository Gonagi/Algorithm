import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int length = sequence.length;
        int leftIdx = 0, rightIdx = 0, sum = 0;
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;

        while(rightIdx < length){
            sum += sequence[rightIdx];            
            while(sum >= k){
                if(sum == k){
                    if(answer[1] - answer[0] > rightIdx - leftIdx){
                        answer[1] = rightIdx;
                        answer[0] = leftIdx;
                    }
                }
                sum -= sequence[leftIdx];
                leftIdx++;
            }
            
            rightIdx++;
        }
        
        return answer;
    }
}
