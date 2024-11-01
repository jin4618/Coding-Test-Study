class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            char nextChar = c;
            int count = 0;
            
            while(count < index) {
                nextChar = (nextChar == 'z') ? 'a' : (char) (nextChar + 1);
                
                if(skip.indexOf(nextChar) == -1) {
                    count++;
                }
            }
                answer.append(nextChar);
        }
        
        return answer.toString();
    }
}