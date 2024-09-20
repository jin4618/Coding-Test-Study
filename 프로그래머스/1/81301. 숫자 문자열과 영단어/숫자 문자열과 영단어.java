import java.util.*;

class Solution {
    public int solution(String s) {
        
        Map<String, String> engNums = new HashMap<>();
        
        engNums.put("zero", "0");
        engNums.put("one", "1");
        engNums.put("two", "2");
        engNums.put("three", "3");
        engNums.put("four", "4");
        engNums.put("five", "5");
        engNums.put("six", "6");
        engNums.put("seven", "7");
        engNums.put("eight", "8");
        engNums.put("nine", "9");

        StringBuilder result = new StringBuilder();
        StringBuilder check = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c);
            } else {
                check.append(c);
                String word = check.toString();
                if (engNums.containsKey(word)) {
                    result.append(engNums.get(word));
                    check.setLength(0);
                }
            }
        }

        return Integer.parseInt(result.toString());
    }
}