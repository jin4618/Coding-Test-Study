class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int left = 10;  // *
        int right = 12; // #
        
        for(int number : numbers) {
            number = (number == 0) ? 11 : number;
            
            if(number == 1 || number == 4 || number == 7) { // 왼쪽 열
                answer.append("L");
                left = number;
            }
            
            else if(number == 3 || number == 6 || number == 9) {    // 오른쪽 열
                answer.append("R");
                right = number;
            }
            
            else {  // 가운데 열
                // ...모르겠어요...
                
                // 각 손의 거리 계산
                int leftDistance = getDistance(left, number);
                int rightDistance = getDistance(right, number);
                
                // 거리 같은 경우
                if(leftDistance == rightDistance) {
                    if(hand.equals("right")) {
                        answer.append("R");
                        right = number;
                    } else {
                        answer.append("L");
                        left = number;
                    }
                }
                
                // 거리 다른 경우
                else if(leftDistance < rightDistance) { // 왼쪽 거리가 더 가까울 경우
                    answer.append("L");
                    left = number;
                } else {
                    answer.append("R");
                    right = number;
                }
            }
        }
        
        
        return answer.toString();
    }
    
    // 키패드 기준 거리 계산 (=> 맨해튼 거리 계산)
    // 맨해튼 거리 : 직선 거리가 아닌 좌우와 상하로만 이동할 때 한 점에서 다른 점으로 이동하는 최단 거리
    private int getDistance(int from, int to) {
        int[] fromCoord = getCoordinates(from);
        int[] toCoord = getCoordinates(to);
        
        // 맨해튼 거리 = |x1 - x2| + |y1 - y2|
        return Math.abs(fromCoord[0] - toCoord[0]) + Math.abs(fromCoord[1] - toCoord[1]);
    }
    
    // 키패드 숫자 -> 좌표로
    private int[] getCoordinates(int number) {
        int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };
        
        for(int i = 0; i < keypad.length; i++) {
            for(int j = 0; j < keypad[i].length; j++) {
               if(keypad[i][j] == number) {
                   return new int[]{i, j};
               } 
            }
        }
        
        return new int[]{0, 0};
    }
}