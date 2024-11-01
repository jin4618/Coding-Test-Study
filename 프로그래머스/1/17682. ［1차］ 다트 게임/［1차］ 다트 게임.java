class Solution {
    public int solution(String dartResult) {
        int[] rounds = new int[3];
        int round = 0;
        
        StringBuilder numBuilder = new StringBuilder();
        
        for(char c : dartResult.toCharArray()) {
            if(Character.isDigit(c)) {
                numBuilder.append(c);
            }
            else if(c == 'S' || c == 'D' || c == 'T') {
                int score = Integer.parseInt(numBuilder.toString());
                numBuilder.setLength(0);
                
                rounds[round] = calculateBonus(score, c);
                
                round++;
            }
            else {
                if(c == '*') {
                    rounds[round - 1] *= 2;
                    if(round > 1) {
                        rounds[round - 2] *= 2;
                    }
                }
                else if(c == '#') {
                    rounds[round - 1] *= -1;
                }
            }
        }
        
        return rounds[0] + rounds[1] + rounds[2];
    }
    
    private int calculateBonus(int score, char bonus) {
        switch(bonus) {
            case 'D': return score * score;
            case 'T' : return score * score * score;
                default : return score;
        }
    }
}