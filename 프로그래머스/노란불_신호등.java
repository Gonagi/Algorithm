import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int size = signals.length;
        int maxDist = 1;
        
        for(int[] signal : signals){
            maxDist = Math.max(maxDist, lcm(maxDist, (signal[0] + signal[1] + signal[2])));
        }
        
        for(int t = 1; t <= maxDist; t++){
            boolean check = true;
            for(int[] signal : signals){
                int cycle = signal[0] + signal[1] + signal[2];
                int isYellow = t % cycle;
                if(isYellow <= signal[0] || isYellow > signal[0] + signal[1]){
                    check = false;
                    break;
                }
            }
            if(check){
                return t;
            }
        }
        return -1;
    }
    
    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
    
    private int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
}

