class Solution {
    public int solution(int[] ingredient) {
        // 1: 빵, 2: 야채, 3: 고기 => 1231
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i : ingredient) {
            sb.append(i);
        
            if(sb.length() >= 4) {
                int len = sb.length();
                if(sb.charAt(len - 4) == '1' &&
                    sb.charAt(len - 3) == '2' &&
                    sb.charAt(len - 2) == '3' &&
                    sb.charAt(len - 1) == '1') {

                    sb.setLength(len - 4);
                    answer++;
                }
            }
        
        }
        return answer;
    }
}