class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int current = 0;
        
        for(int i = 0; i < section.length; i++) {
            if(section[i] > current) {
                answer++;
                current = section[i] + m - 1;
            }
        }
        
        return answer;
    }
}