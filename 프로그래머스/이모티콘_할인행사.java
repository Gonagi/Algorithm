import java.util.*;

class Solution {
    static int count = 0, sum = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        
        comb(0, discount, users, emoticons);
        
        int[] answer = new int[]{count, sum};
        return answer;
    }
    
    private static void comb(int start, int[] discount, int[][] users, int[] emoticons){
        if(start == emoticons.length){
            calculate(discount, users, emoticons);
            return;
        }
        
        for(int idx = 10; idx <= 40; idx+= 10){
            discount[start] = idx;
            comb(start + 1, discount, users, emoticons);
        }
    }
    
    private static void calculate(int[] discount, int[][] users, int[] emoticons){
        int[] prices = new int[emoticons.length];
        for(int idx = 0; idx < emoticons.length; idx++){
            prices[idx] = emoticons[idx] * (100 - discount[idx]) / 100;
        }
        
        int curCount = 0; int curSum = 0;
        for(int userIdx = 0; userIdx < users.length; userIdx++){
            int tempSum = 0;
            
            for(int idx = 0; idx < discount.length; idx++){
                if(users[userIdx][0] <= discount[idx]){
                    tempSum += prices[idx];
                }
            }
            
            if(tempSum >= users[userIdx][1]) {
                curCount++;
            } else {
                curSum += tempSum;
            }
        
            if(count < curCount) {
                count = curCount;
                sum = curSum;
            } else if(count == curCount){
                if(sum < curSum) {
                    sum = curSum;
                }
            }
        }
    }
}

