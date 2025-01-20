class Solution {
    public int solution(int n) {
        // 1. 3진법으로 변환
        String ternary = Integer.toString(n, 3);
        
        // 2. 문자열 뒤집기
        StringBuilder sb = new StringBuilder(ternary);
        String reversed = sb.reverse().toString();
        
        // 3. 10진수로 변환
        return Integer.parseInt(reversed, 3);
    }
}