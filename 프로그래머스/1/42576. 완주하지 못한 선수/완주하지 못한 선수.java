import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> runners = new HashMap<>();
        
        for(String name : participant) {
            runners.put(name, runners.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            runners.put(name, runners.get(name) - 1);
            if(runners.get(name) == 0) {
                runners.remove(name);
            }
        }
        
        return runners.keySet().iterator().next();
    }
}