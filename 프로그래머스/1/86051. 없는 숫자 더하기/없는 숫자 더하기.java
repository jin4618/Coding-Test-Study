import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        int sum = 0;
        
        for(int num : numbers)
            sum += num;
        
        answer -= sum;
        
        return answer;
    }
}