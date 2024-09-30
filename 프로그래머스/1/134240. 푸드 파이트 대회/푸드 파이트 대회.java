class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                left.append(i);
                right.insert(0, i);
            }
        }
        
        answer = left.toString() + "0" + right.toString();
        
        return answer;
    }
}