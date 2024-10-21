import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);    // 점수 정렬
        
        for(int i = score.length - m; i >= 0; i -= m) { // 뒤부터 m개씩
            answer += score[i] * m;
        }
        
        return answer;
    }
}