class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int len = number.length;
        
        for(int n = 0; n < len; n++) {
            for(int i = n + 1; i < len; i++) {
                for(int j = i + 1; j < len; j++) {
                    if(number[n] + number[i] + number[j] == 0)
                        answer++;
                }
            }
        }
        
        return answer;
    }
}