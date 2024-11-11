import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> minClicks = new HashMap<>();
        
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                
                minClicks.put(c, Math.min(
                    minClicks.getOrDefault(c, Integer.MAX_VALUE), i + 1
                ));
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            int totalClicks = 0;
            boolean impossible = false;
            
            for(char c : targets[i].toCharArray()) {
                if(!minClicks.containsKey(c)) {
                    impossible = true;
                    break;
                }
                totalClicks += minClicks.get(c);
            }
            
            answer[i] = impossible ? -1 : totalClicks;
        }
        
        
        return answer;
    }
}