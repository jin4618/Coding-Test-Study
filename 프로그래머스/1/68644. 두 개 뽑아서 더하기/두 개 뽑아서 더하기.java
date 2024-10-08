import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> result = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[result.size()];
        
        int index = 0;
        for (Integer num : result) {
            answer[index++] = num.intValue();
        }
        
        // int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(answer);
        
        return answer;
    }
}