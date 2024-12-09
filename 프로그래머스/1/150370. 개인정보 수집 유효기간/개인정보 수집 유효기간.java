import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜 일수로 변환
        int todayDate = convertToDate(today);
        
        // 약관 유효기간 저장할 맵
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        // 파기할 정보 리스트
        List<Integer> expiredList = new ArrayList<>();
        
        // 각 개인정보 확인
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String privacyDate = privacy[0];
            String termType = privacy[1];
            
            // 해당 약관 유효기간 확인
            int validMonths = termMap.get(termType);
            
            //  개인정보 만료 날짜 계산
            int expireDate = convertToDate(privacyDate) + (validMonths * 28);
            
            // 오늘 날짜랑 비교
            if(expireDate <= todayDate) {
                expiredList.add(i + 1);
            }
        }
        
        // 리스트 => 배열
        return expiredList.stream().mapToInt(i -> i).toArray();
    }
    
    private int convertToDate(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        // 모든 달 28일까지
        return (year * 12 * 28) + ((month - 1) * 28) + day;
        
    }
}