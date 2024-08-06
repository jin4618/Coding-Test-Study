class Solution {
    public int[] solution(int n, int m) {
        // n * m = max * min
        // 1부터 n 까지의 수 중에서 n, m을 모두 나누어 떨어지게 하는 수 중 가장 큰 수가 최대 공약수
        int[] answer = new int[2];
        
        int max = 1;    // 최대 공약수 최소 1
        
        for(int i = 1; i <= Math.min(n, m); i++) {
            // 최대 공약수는 n, m 모두 나누어 떨어지게 하는 수이기 때문에 둘 중 작은 수까지만 돌면 됨
            if(n % i == 0 && m % i == 0) {
                if(max < i) {
                    max = i;
                }
            }
        }
        
        int min = (n * m) / max;
        
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
}