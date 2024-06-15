class Solution {
    public double solution(long n) {
        double answer = 0;
        double check = Math.sqrt(n);
        
        if(check % 1 == 0)
            answer = Math.pow(check + 1, 2);
        else
            answer = -1;
        
        return answer;
    }
}