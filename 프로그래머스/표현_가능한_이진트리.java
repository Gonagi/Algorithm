class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int idx = 0; idx < numbers.length; idx++){
            StringBuffer sb = new StringBuffer();
            long num = numbers[idx];
            while(num != 0L){
                sb.append(num % 2);
                num /= 2;
            }
            String str = sb.reverse().toString();            
            int level = 1, nodeCount = 1;
            while(str.length() > nodeCount){
                level *= 2;
                nodeCount += level;
            }
            int offset = nodeCount - str.length();
            String result = "0".repeat(offset) + str;
            
            if(isBinaryTree(result)){
                answer[idx] = 1;
            } else {
                answer[idx] = 0;
            }
        }
        return answer;
    }
    
    private boolean isBinaryTree(String str){
        int length = str.length();
        if(length == 1){
            return true;
        }
        
        int root = length / 2;
        String leftStr = str.substring(0, root);
        String rightStr = str.substring(root + 1);
        
        if(str.charAt(root) == '0') {
            return !leftStr.contains("1") && !rightStr.contains("1");
        }
        
        return isBinaryTree(leftStr) && isBinaryTree(rightStr);
    }
}

