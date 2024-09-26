class Solution {
    public int solution(int a, int b, int n) {
        int totalCola = 0;
        
        while (n >= a) {
            int changedCola = (n / a) * b;  // 교환으로 받은 콜라의 수
            totalCola += changedCola;       // 총 받은 콜라에 추가
            n = (n % a) + changedCola;      // 남은 병 + 새로 받은 콜라
        }
        
        return totalCola;
    }
}