import java.util.*;

class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();
    
    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);    // 현재 단어 추가
        
        if(word.length() == 5) return words;    // 길이 5면 종료
        
        // 각 모음에 대해 재귀적으로 단어 생성
        for(char c : CHARS) {
            words.addAll(generate(word + c));
        }
        
        return words;
    }
    
    public int solution(String word) {
        // 빈 문자열부터 시작해서 목표 단어 찾기
        return generate("").indexOf(word);
    }
}