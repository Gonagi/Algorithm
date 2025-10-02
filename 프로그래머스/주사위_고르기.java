import java.util.*;
import java.io.*;

class Solution {
    static List<Integer> aList, bList, aSum, bSUm, result;
    static int size, max;
    static int[] realAnswer;
    
    public int[] solution(int[][] dice) {
        size = dice.length;
        max = 0;
        aList = new ArrayList<>();
        bList = new ArrayList<>();
        
        dfs(0, dice);
        
        return realAnswer;
    }
    
    private static void dfs(int curIdx, int[][] dice){
        if(aList.size()  == size / 2){
            bList.clear();
            for(int idx = 0; idx < size; idx++){
                if(!aList.contains(idx)){
                    bList.add(idx);
                }
            }
            
            List<Integer> aResult = new ArrayList<>();
            List<Integer> bResult = new ArrayList<>();
            dfsSum(0, 0, aList, dice, aResult);
            dfsSum(0, 0, bList, dice, bResult);
            
            Collections.sort(bResult);
            
            int count = 0;
            for(int aSum : aResult){
                count += binarySearch(aSum, bResult);
            }
            
            if(max < count){
                max = count;
                realAnswer = aList.stream().mapToInt(i -> i + 1).toArray();
            }
            
            return;
        }
        
        for(int idx = curIdx; idx < size; idx++) {
            aList.add(idx);
            dfs(idx + 1, dice);
            aList.remove(aList.size() - 1);
        }
    }
    
    private static void dfsSum(int depth, int sum, List<Integer> list, int[][] dice, List<Integer> result){
        if(depth == list.size()){
            result.add(sum);
            return;
        }
        
        for(int idx = 0; idx < 6; idx++) {
            dfsSum(depth + 1, sum + dice[list.get(depth)][idx], list, dice, result);
        }
    }
    
    private static int binarySearch(int aSum, List<Integer> bResult) {
        int left = 0, right = bResult.size();
        
        while(left < right){
            int middle = left + (right - left) / 2;
            
            if(bResult.get(middle) < aSum){
                left = middle + 1;
            }else{
                right = middle;
            }
        }
        
        return left;
    }
}
