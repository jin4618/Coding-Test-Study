import java.util.Arrays;
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        /*for(int i = 0; i < absolutes.length; i++) {
            if(!signs[i]) {
                absolutes[i] *= -1;
            }
        }
        
        answer = Arrays.stream(absolutes).sum();*/
        for(int i = 0; i < absolutes.length; i++) {
            answer += absolutes[i] * (signs[i]? 1: -1);
        }
        
        return answer;
    }
}