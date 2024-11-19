import java.util.*;

class Solution {
    static int startIndex;

    public int[] solution(int[][] edges) {
        int[] start = new int[1000001];
        int[] end = new int[1000001];
        int doughnutCount = 0;
        int barCount = 0;
        int eightCount = 0;
        int graphCount = 0;

        for (int[] edge : edges) {
            start[edge[0]]++;
            end[edge[1]]++;
        }

        for (int idx = 1; idx < 1000001; idx++) {
            if (start[idx] >= 2 && end[idx] == 0) {
                startIndex = idx;
                graphCount = start[idx];
            } else if (start[idx] == 0 && end[idx] > 0) {
                barCount++;
            } else if (start[idx] == 2 && end[idx] >= 2) {
                eightCount++;
            }
        }
        doughnutCount = graphCount - barCount - eightCount;
        int[] answer = new int[] { startIndex, doughnutCount, barCount, eightCount };
        return answer;
    }
}

/**
 * import java.util.*;
 * 
 * class Solution {
 * static Map<Integer, int[]> map = new HashMap<>();
 * static int doughnutCount = 0;
 * static int barCount = 0;
 * static int eightCount = 0;
 * static int graphCount = 0;
 * static int startNode;
 * 
 * public int[] solution(int[][] edges) {
 * for(int[] edge : edges){
 * int start = edge[0];
 * int end = edge[1];
 * 
 * if(!map.containsKey(start)){
 * map.put(start, new int[]{0,0});
 * }
 * if(!map.containsKey(end)){
 * map.put(end, new int[]{0,0});
 * }
 * map.get(start)[0]++;
 * map.get(end)[1]++;
 * }
 * 
 * for(int key : map.keySet()){
 * int[] count = map.get(key);
 * int start = count[0];
 * int end = count[1];
 * 
 * 
 * if(start >= 2 && end == 0){
 * startNode = key;
 * graphCount = start;
 * }else if(start == 0){
 * barCount++;
 * }else if(start == 2 && end >= 2){
 * eightCount++;
 * }
 * }
 * doughnutCount = graphCount - barCount - eightCount;
 * int[] answer = new int[]{startNode, doughnutCount, barCount, eightCount};
 * return answer;
 * }
 * 
 * 
 * }
 **/
