class Solution {
    public int solution(int[] ingredient) {
        // 1: 빵, 2: 야채, 3: 고기 => 1231
        int answer = 0;
        
        StringBuilder stack = new StringBuilder();
        
        for(int i : ingredient) {
            stack.append(i);
        
            if(stack.length() >= 4) {
                int len = stack.length();
                if(stack.charAt(len - 4) == '1' &&
                    stack.charAt(len - 3) == '2' &&
                    stack.charAt(len - 2) == '3' &&
                    stack.charAt(len - 1) == '1') {

                    stack.setLength(len - 4);
                    answer++;
                }
            }
        
        }
        return answer;
    }
}