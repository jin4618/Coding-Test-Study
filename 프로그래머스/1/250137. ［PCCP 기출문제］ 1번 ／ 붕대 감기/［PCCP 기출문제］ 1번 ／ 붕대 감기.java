class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;    // 초기 체력 answer에 저장
        int lastAttackTime = 0; // 마지막으로 공격 받은 시간
        int successTime = 0;    // 연속 성공 시간
        
        for(int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];
            
            int healingTime = attackTime - lastAttackTime - 1;
            
            // 체력 회복
            for(int i = 0; i < healingTime; i++) {
                // 초당 체력 회복
                answer += bandage[1];
                successTime++;
                
                // 연속 성공 시 추가 회복
                if(successTime == bandage[0]) {
                    answer += bandage[2];
                    successTime = 0;
                }
                
                // 최대 체력 초과 방지
                answer = Math.min(answer, health);
            }
            
            // 공격 받았을 때 데미지 처리
            answer -= damage;
            
            // 체력 0 이하 죽음
            if(answer <= 0) {
                return -1;
            }
            
            // 연속 성공 시간 초기화
            successTime = 0;
            
            // 마지막 공격 시간 업데이트
            lastAttackTime = attackTime;
            
        }
        return answer;
    }
}