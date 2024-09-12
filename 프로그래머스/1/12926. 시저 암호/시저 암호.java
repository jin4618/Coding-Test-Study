class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c)) {
                char check = Character.isUpperCase(c) ? 'A' : 'a';
                answer.append((char) ((c - check + n) % 26 + check));
            } else {
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}