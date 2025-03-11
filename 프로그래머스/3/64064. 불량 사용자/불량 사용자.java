import java.util.*;

class Solution {
    // 패턴 매칭 함수
    private boolean isMatch(String userId, String bannedId) {
        // 길이가 다르면 매칭 불가
        if(userId.length() != bannedId.length()) {
            return false;
        }
        
        // 각 위치의 문자 비교
        for(int i = 0; i < userId.length(); i++) {
            // '*'는 모든 문자와 매칭, 그 외에는 정확히 일치해야 함
            if(bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void findBannedCombinations(String[] user_id, String[] banned_id, int index, Set<Integer> currentBanned, Set<Set<String>> answer) {
        // 모든 불량 사용자 패턴을 처리한 경우
        if(index == banned_id.length) {
            // 현재 조합을 결과에 추가
            Set<String> bannedUsers = new HashSet<>();
            for(int i : currentBanned) {
                bannedUsers.add(user_id[i]);
            }
            answer.add(bannedUsers);
            return;
        }
        
        // 현재 불량 사용자 패턴에 매칭되는 사용자 찾기
        for(int i = 0; i < user_id.length; i++) {
            // 이미 선택된 사용자는 건너뜀
            if(currentBanned.contains(i)) continue;
            
            // 패턴 매칭 확인
            if(isMatch(user_id[i], banned_id[index])) {
                // 현재 사용자를 선택하고 다음 패턴으로 진행
                currentBanned.add(i);
                findBannedCombinations(user_id, banned_id, index + 1, currentBanned, answer);
                // 현재 사용자 선택 취소
                currentBanned.remove(i);
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> answer = new HashSet<>();
        
        findBannedCombinations(user_id, banned_id, 0, new HashSet<>(), answer);
        
        return answer.size();
    }
}