import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        // 각 친구가 서로에게 선물을 몇 번 줬는지
        Map<String, Map<String, Integer>> giftData = new HashMap<>();
        for(String friend : friends) {
            giftData.put(friend, new HashMap<>());
        }
        
        // 선물 기록 처리
        for(String gift : gifts) {
            String[] pair = gift.split(" ");
            String giver = pair[0]; // 선물 주는 사람
            String receiver = pair[1];  // 선물 받는 사람
            
            giftData.get(giver).put(receiver, giftData.get(giver).getOrDefault(receiver, 0) + 1);
        }
        
        // 선물 지수 계산
        Map<String, Integer> giftIndex = new HashMap<>();
        for(String friend : friends) {
            int given = 0;  // 준 선물 총합
            int received = 0;   // 받은 선물 총합
            
            // 준 선물
            for(int count : giftData.get(friend).values()) {
                given += count;
            }
            
            // 받은 선물
            for(String otherFriend : friends) {
                received += giftData.getOrDefault(otherFriend, new HashMap<>()).getOrDefault(friend, 0);
            }
            
            // 선물 지수 계산
            giftIndex.put(friend, given - received);
        }
        
        // 다음 달 선물 수 계산
        Map<String, Integer> nextMonthGifts = new HashMap<>();
        for(String friend : friends) {
            nextMonthGifts.put(friend, 0);
        }
        
         // 선물 주고받기 계산
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String friendA = friends[i];
                String friendB = friends[j];
                
                int countAtoB = giftData.get(friendA).getOrDefault(friendB, 0);
                int countBtoA = giftData.get(friendB).getOrDefault(friendA, 0);
                
                if (countAtoB > countBtoA) {
                    nextMonthGifts.put(friendA, nextMonthGifts.get(friendA) + 1);
                } else if (countAtoB < countBtoA) {
                    nextMonthGifts.put(friendB, nextMonthGifts.get(friendB) + 1);
                } else {
                    // 선물 횟수가 같다면 선물 지수 비교
                    int indexA = giftIndex.get(friendA);
                    int indexB = giftIndex.get(friendB);
                    
                    if (indexA > indexB) {
                        nextMonthGifts.put(friendA, nextMonthGifts.get(friendA) + 1);
                    } else if (indexA < indexB) {
                        nextMonthGifts.put(friendB, nextMonthGifts.get(friendB) + 1);
                    }
                    // 지수가 같으면 선물 주고받지 않음
                }
            }
        }
        
        // 가장 많이 받는 선물 수 계산
        int answer = 0;
        for (int count : nextMonthGifts.values()) {
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}