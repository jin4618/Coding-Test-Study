class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            int combine = arr1[i] | arr2[i];
            
            String binaryStr = Integer.toBinaryString(combine);
            
            binaryStr = String.format("%" + n + "s", binaryStr);
            
            answer[i] = binaryStr.replace('1', '#').replace('0', ' ');
        }
        
        return answer;
    }
}