class Solution {
    public int[] solution(String s) {
        int convertCount = 0;   // 변환 횟수
        int removedZeros = 0;   // 제거된 0의 총 개수
        
        while(!s.equals("1")) { // 변환 반복
            // 현재 문자열의 0 개수 세기
            int zeros = countZeros(s);
            removedZeros += zeros;
            
            // 0을 제거하고 남은 1의 개수
            int ones = s.length() - zeros;
            
            // 1의 개수를 2진수 문자열로 변환
            s = Integer.toBinaryString(ones);
            convertCount++;
        }
        
        return new int[]{convertCount, removedZeros};
    }
    
    private int countZeros(String s) {
        int count = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '0') count++;
        }
        
        return count;
    }
}