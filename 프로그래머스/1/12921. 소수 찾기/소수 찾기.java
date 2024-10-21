class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            if(!check[i]) {
                answer++;
            
                for(int j = i + i; j <= n; j += i) {
                    check[j] = true;
                }
            }
        }        
        
        return answer;
    }
}