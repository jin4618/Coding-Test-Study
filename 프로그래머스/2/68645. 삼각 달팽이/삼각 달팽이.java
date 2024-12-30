class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int value = 1;
        int row = 0, col = 0;
        int direction = 0;  // 0: 아래, 1: 오른쪽, 2: 왼쪽 위
        
        // 전체 채워야 할 숫자 개수
        int totalCount = n * (n + 1) / 2;   // 삼각형 내부 칸 수
        
        while(value <= totalCount) {
            // 현재 위치에 값 채우기
            triangle[row][col] = value++;
            
            // 다음 위치 계산
            if(direction == 0) {    // 아래로 이동
                if(row + 1 < n && triangle[row + 1][col] == 0)
                    row++;
                else {
                    direction = 1;
                    col++;
                }
            }
            else if(direction == 1) {   // 오른쪽으로 이동
                if(col + 1 < n && triangle[row][col + 1] == 0)
                    col++;
                else {
                    direction = 2;
                    row--;
                    col--;
                }
            }
            else {  // 왼쪽 위로 이동
                if(row - 1 >= 0 && col - 1 >= 0 && triangle[row - 1][col - 1] == 0) {
                    row--;
                    col--;
                }
                else {
                    direction = 0;
                    row++;
                }
            }
        }
        
        // 1차원 배열로 변환
        int[] answer = new int[totalCount];
        int idx = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}