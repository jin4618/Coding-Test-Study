class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        
        char[] chars = sb.toString().toCharArray();
        
        int[] answer = new int[chars.length];
        for(int i = 0; i < chars.length; i++) {
            answer[i] = chars[i] - '0';
        }
        return answer;
    }
}