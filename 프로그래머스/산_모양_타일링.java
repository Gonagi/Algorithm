class Solution {
    public int solution(int n, int[] tops) {
        int[] result = new int[n + 1];
        int[] count = new int[2 * n + 2]; 
        
        if(n == 1) {
            if(tops[0] == 1){
                return 4;
            }
            return 3;
        }
        
        count[1] = 1;
        if(tops[0] == 1){
            count[2] = 3;
            count[3] = 4;
            result[1] = 4;
        } else{
            count[2] = 2;
            count[3] = 3;
            result[1] = 3;
        }
        
        for(int idx = 3; idx <= 2 * n; idx++){
            if(idx % 2 == 0){
                if(tops[idx / 2 - 1] == 1){
                    count[idx] = ((count[idx - 1] * 2) % 10007 + count[idx - 2]) % 10007;
                } else {
                    count[idx] = (count[idx - 1] + count[idx - 2]) % 10007;
                }
            } else{
                count[idx] = (count[idx - 1] + count[idx - 2]) % 10007;
                result[idx / 2] = count[idx];
            }
        }
        
        return (count[2 * n] + count[2 * n - 1]) % 10007;
    }
}

