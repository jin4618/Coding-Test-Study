class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        
        for(int r = 0; r < wallpaper.length; r++) {
            for(int c = 0; c < wallpaper[r].length(); c++) {
                // 파일('*') 위치 찾기
                if(wallpaper[r].charAt(c) == '#') {
                    // 최소 행
                    minRow = Math.min(minRow, r);
                    // 최대 행
                    maxRow = Math.max(maxRow, r + 1);
                    // 최소 열
                    minCol = Math.min(minCol, c);
                    // 최대 열
                    maxCol = Math.max(maxCol, c + 1);
                }
            }
        }
        
        return new int[]{minRow, minCol, maxRow, maxCol};
    }
}