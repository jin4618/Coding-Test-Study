class Solution {
    private static final String[] WORDS = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    
    public int solution(String s) {
        for(int i = 0; i < WORDS.length; i++) {
            s = s.replace(WORDS[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}