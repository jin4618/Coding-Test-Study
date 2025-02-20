class Solution {
    int[] answer = new int[2];  // 0과 1의 개수를 저장할 배열
    
    public int[] solution(int[][] arr) {
        
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    
    private void compress(int[][] arr, int x, int y, int size) {
        // 현재 영역이 모두 같은 수인지 확인
        if(isCompressible(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }
        
        // 4등분해서 재귀 호출
        int newSize = size / 2;
        compress(arr, x, y, newSize);   // 좌상
        compress(arr, x, y + newSize, newSize);   // 우상
        compress(arr, x + newSize, y, newSize);   // 좌하
        compress(arr, x + newSize, y + newSize, newSize);   // 우하
    }
    
    private boolean isCompressible(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(arr[i][j] != value) return false;
            }
        }
        return true;
    }
}