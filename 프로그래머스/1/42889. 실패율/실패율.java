class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] failureRate = new double[N];    // 각 스테이지의 실패율
        int[] stagePlayers = new int[N + 1];    // 각 스테이지에 클리어하지 못한 플레이어 수
        
        for(int stage : stages) {    // 각 스테이지별 도전 중인 플레이어 수 계산
            if(stage <= N) {
                stagePlayers[stage]++;
            }
        }
        
        // 실패율 계산
        int totalPlayers = stages.length;   // 총 플레이어 수
        for(int i = 1; i <= N; i++) {
            if(totalPlayers > 0) {
                failureRate[i - 1] = (double) stagePlayers[i] / totalPlayers;
                totalPlayers -= stagePlayers[i];    // 스테이지 번호 초기화/ 스테이지 번호 초기화
            }
            
            answer[i - 1] = i;
        }
        
        // 버블 정렬 이용하여 실패율 내림차순 정렬
        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < N - 1 - i; j++) {
                if(failureRate[j] < failureRate[j + 1] || (failureRate[j] == failureRate[j + 1] && answer[j] > answer[j + 1])) {
                    // 실패율 교환
                    double tempRate = failureRate[j];
                    failureRate[j] = failureRate[j + 1];
                    failureRate[j + 1] = tempRate;
                    
                    // 스테이지 번호 교환
                    int tempStage = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = tempStage;
                }
            }
        }
        
        return answer;
    }
}