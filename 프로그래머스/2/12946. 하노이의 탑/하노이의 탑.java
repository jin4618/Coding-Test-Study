import java.util.*;

class Solution {
    private List<int[]> moves = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);  // n개의 원판을 1번에서 3번으로 이동
        return moves.toArray(new int[0][]);
    }
    
    private void hanoi(int n, int from, int aux, int to) {
        if(n == 1) {
            moves.add(new int[]{from, to}); // 원판 1개는 직접 이동
            return;
        }
        
        // n - 1개의 원판을 보조 기둥으로 이동
        hanoi(n-1, from, to, aux);
        
        // 가장 큰 원판을 목표 기둥으로 이동
        moves.add(new int[]{from, to});
        
        // n - 1개의 원판을 목표 기둥으로 이동
        hanoi(n-1, aux, from, to);
    }
}