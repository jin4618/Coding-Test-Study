import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        int[] answer = {};
        
        for(int element : arr) {
            if(element % divisor == 0) {
                list.add(element);
            }
        }
        
        if(list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            Collections.sort(list);
            answer = new int[list.size()];
            
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        
        
        return answer;
    }
}