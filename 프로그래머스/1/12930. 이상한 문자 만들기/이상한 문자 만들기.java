public class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isSpace = true; // 공백을 기준으로 다음 문자는 대문자
        
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                answer.append(c); // 공백은 그대로 추가
                isSpace = true; // 공백이면 다음은 대문자
            } else {
                if (isSpace) {
                    answer.append(Character.toUpperCase(c)); // 대문자로 변환
                } else {
                    answer.append(Character.toLowerCase(c)); // 소문자로 변환
                }
                isSpace = !isSpace;
            }
        }

        return answer.toString();
    }
}
