class Solution {
    public int solution(String[][] board, int h, int w) {
        // 보드의 크기
        int n = board.length;
        
        int[] dh = {0, 1, -1, 0};  // 상하좌우 h방향
        int[] dw = {1, 0, 0, -1};  // 상하좌우 w방향
        
        // 같은 색상의 개수를 카운트
        int count = 0;
        
        // 4방향 확인
        for (int i = 0; i < 4; i++) {
            // 확인할 칸의 h, w 좌표 계산
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            
            // 보드 범위 내에 있는지 확인
            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                // 같은 색상인지 확인
                if (board[h_check][w_check].equals(board[h][w])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}