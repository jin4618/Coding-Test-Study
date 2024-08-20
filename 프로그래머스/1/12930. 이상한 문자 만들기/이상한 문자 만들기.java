class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] sArr = s.split(" ", -1);
        
        for(int i = 0; i < sArr.length; i++) {
            String[] word = sArr[i].split("");
            
            for(int j = 0; j < word.length; j++) {
                if(j % 2 == 0) {
                    word[j] = word[j].toUpperCase();
                }
                else {
                    word[j] = word[j].toLowerCase();
                }
            }
            sArr[i] = String.join("", word);
        }
        
        answer = String.join(" ", sArr);
        
        return answer;
    }
}