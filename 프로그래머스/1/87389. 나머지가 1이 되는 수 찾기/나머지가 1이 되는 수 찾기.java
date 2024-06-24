class Solution {
    public int solution(int n) {
        int answer = 0;
        
        /* while(answer < n) {
            answer++;
            if(n % answer == 1)
                break;
        }*/
        
        for(int i = 2; i < n; i++) {
            if(n % i == 1) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}