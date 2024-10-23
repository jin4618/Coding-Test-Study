class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] possible = {"aya", "ye", "woo", "ma"};
        String[] impossible = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for(String word : babbling) {
            boolean check = false;
            
            for(String i : impossible) {
                if(word.contains(i)) {
                    check = true;
                    break;
                }
            }
            
            if(check) continue;
            
            String checkWord = word;
            for(String p : possible) {
                checkWord = checkWord.replace(p, "X");
            }
            
            checkWord = checkWord.replace("X", "");
            
            if(checkWord.length() == 0) {
                answer++;
            }
            
            
        }
        
        return answer;
    }
}