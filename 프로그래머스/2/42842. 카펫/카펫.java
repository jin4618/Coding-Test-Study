class Solution {
    public int[] solution(int brown, int yellow) {
        for (int yellowHeight = 1; yellowHeight <= yellow; yellowHeight++) {
            if (yellow % yellowHeight != 0) continue;
            
            int yellowWidth = yellow / yellowHeight;
            
            // 전체 카펫 크기
            int totalHeight = yellowHeight + 2;
            int totalWidth = yellowWidth + 2;
            
            // 갈색 격자 수 계산 및 확인
            int checkBrown = totalHeight * totalWidth - yellow;
            
            if (checkBrown == brown && totalWidth >= totalHeight) {
                return new int[] {totalWidth, totalHeight};
            }
        }
        
        return new int[] {0, 0};
    }
}