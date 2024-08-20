class Solution {
    public int solution(String t, String p) {   // p의 길이 18까지 => int x
        int answer = 0;
        
        for(int i = 0; i <= t.length() - p.length(); i++) {
            String check = t.substring(i, i + p.length());
            
            if(Long.parseLong(check) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}