class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') { // 공백은 그대로 추가
                answer.append(' ');
            } else if (Character.isUpperCase(c)) { // 대문자 처리
                answer.append((char) ((c - 'A' + n) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) { // 소문자 처리
                answer.append((char) ((c - 'a' + n) % 26 + 'a'));
            }
        }
        
        return answer.toString();
    }
}