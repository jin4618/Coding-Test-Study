import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복 신고 제거
        Set<String> setReports = new HashSet<>(Arrays.asList(report));
        
        // 각 유저별 신고당한 횟수
        Map<String, Integer> reportedCount = new HashMap<>();
        
        // 각 유저가 신고한 유저들
        Map<String, Set<String>> reporterMap = new HashMap<>();
        
        // 1단계 : 신고 횟수, 신고자 정보 처리
        for (String rep : setReports) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            // 신고당한 횟수
            reportedCount.put(reported, reportedCount.getOrDefault(reported, 0) + 1);
            
            // 신고자별 신고한 유저 목록 추적
            if (!reporterMap.containsKey(reporter)) {
                reporterMap.put(reporter, new HashSet<>());
            }
            reporterMap.get(reporter).add(reported);
        }
        
        // 2단계 : 정지된 유저 식별
        Set<String> bannedUsers = new HashSet<>();
        for (Map.Entry<String, Integer> entry : reportedCount.entrySet()) {
            if (entry.getValue() >= k) {
                bannedUsers.add(entry.getKey());
            }
        }
        
        // 3단계 : 각 유저별 메일 수 계산
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            
            // 해당 유저가 신고한 유저 중 정지된 유저 수 계산
            if (reporterMap.containsKey(user)) {
                int mailCount = 0;
                for (String reportedUser : reporterMap.get(user)) {
                    if (bannedUsers.contains(reportedUser)) {
                        mailCount++;
                    }
                }
                answer[i] = mailCount;
            }
        }
        
        return answer;
    }
}