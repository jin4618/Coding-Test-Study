import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수 이름과 현재 등수 매핑
        Map<String, Integer> playerRankMap = new HashMap<>();
        
        // 초기 등수 설정
        for(int i = 0; i < players.length; i++) {
            playerRankMap.put(players[i], i);
        }
        
        // 호명된 선수들에 대해 순위 변경
        for(String calledPlayer : callings) {
            // 현재 호명된 선수의 현재 등수
            int currentRank = playerRankMap.get(calledPlayer);
            
            // 앞 선수 이름 찾기
            String frontPlayer = players[currentRank - 1];
            
            // players 배열에서 선수들의 위치 교환
            players[currentRank - 1] = calledPlayer;
            players[currentRank] = frontPlayer;
            
            // 등수 업데이트
            playerRankMap.put(calledPlayer, currentRank - 1);
            playerRankMap.put(frontPlayer, currentRank);
        }
        
        return players;
    }
}