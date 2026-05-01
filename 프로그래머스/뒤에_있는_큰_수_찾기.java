import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        Arrays.fill(answer, -1);
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int idx = 0; idx < length; idx++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[idx]){
                int index = stack.pop();
                answer[index] = numbers[idx];
            }
            stack.push(idx);
        }
        
        return answer;
    }
}

