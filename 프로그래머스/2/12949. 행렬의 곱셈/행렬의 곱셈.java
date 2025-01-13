class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;    // arr1의 행 개수
        int m = arr2[0].length; // arr2의 열 개수
        int k = arr1[0].length; // arr1의 열 && arr2의 행 개수
        
        int[][] answer = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int x = 0; x < k; x++) {
                    answer[i][j] += arr1[i][x] * arr2[x][j];
                }
            }
        }
        return answer;
    }
}