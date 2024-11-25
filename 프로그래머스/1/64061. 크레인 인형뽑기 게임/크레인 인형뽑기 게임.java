import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();  // 인형 담을 바구니
        
        for(int move : moves) {
            int crane = move - 1;   // 크레인 위치 0부터
            
            for(int row = 0; row < board.length; row++) {   // 맨 위 인형 찾기
                if(board[row][crane] != 0) {    // 인형 발견
                    int doll = board[row][crane];
                    
                    if(!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();   // 바구니에서 인형 삭제
                        answer += 2;    // 사라진 인형 2개 카운트
                    } else {
                        basket.push(doll);
                    }
                    
                    board[row][crane] = 0;  // 인형 잡은 위치 빈칸으로
                    break;
                }
            }
        }
        
        return answer;
    }
}