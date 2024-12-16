import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 내림차순으로 돗자리 크기 정렬
        Arrays.sort(mats);
        
        // 가장 큰 돗자리부터
        for(int k = mats.length - 1; k >= 0; k--) {
            int answer = mats[k];   // answer를 현재 돗자리 크기로 초기화
            
            // 돗자리를 놓을 수 있는 위치 확인
            for(int i = 0; i <= park.length - answer; i++) {
                for(int j = 0; j <= park[0].length - answer; j++) {
                    // 현재 위치에 돗자리를 놓을 수 있는지 확인
                    boolean canPosition = true;
                    
                    for(int r = i; r < i + answer; r++) {
                        for (int c = j; c < j + answer; c++) {
                            // -1 외 다른 값이 있으면 해당 위치에 돗자리 놓기 불가능
                            if(!park[r][c].equals("-1")) {
                                canPosition = false;
                                break;
                            }
                        }
                        
                        // 이미 놓을 수 없다고 판단될 경우
                        if(!canPosition) break;
                    }
                    
                    // 돗자리 놓기 가능하면 바로 크기 반환
                    if(canPosition) {
                        return answer;
                    }
                }
            }
        }
        
        return -1;
    }
}