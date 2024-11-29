class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = ext.equals("code") ? 0 :
        ext.equals("date") ? 1 :
        ext.equals("maximum") ? 2 : 3;
        
        int sortIdx = sort_by.equals("code") ? 0 :
        sort_by.equals("date") ? 1 :
        sort_by.equals("maximum") ? 2 : 3;
        
        int[][] temp = new int[data.length][4];
        int count = 0;
        
        for(int[] item : data) {
            if(item[extIdx] < val_ext) {
                temp[count++] = item;
            }
        }
        
        int[][] answer = new int[count][4];
        for(int i = 0; i < count; i++) {
            for(int j = 0; j < 4; j++) {
                answer[i][j] = temp[i][j];
            }
        }
        
        for(int i = 0; i < count - 1; i++) {
            for(int j = 0; j < count - 1 - i; j++) {
                if(answer[j][sortIdx] > answer[j + 1][sortIdx]) {
                    int[] t = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = t;
                }
            }
        }
        
        return answer;
    }
}