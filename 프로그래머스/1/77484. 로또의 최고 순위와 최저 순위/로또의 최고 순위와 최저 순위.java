import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int answerCount = 0;
        
        HashSet<Integer> winNumSet = new HashSet<>();
        
        for(int num : win_nums) {
            winNumSet.add(num);
        }
        
        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
            } else if(winNumSet.contains(lotto)) {
                answerCount++;
            }
        }
        
        answer[0] = Math.min(7 - (zeroCount + answerCount), 6);
        answer[1] = Math.min(7 - answerCount, 6);
        
        return answer;
    }
}