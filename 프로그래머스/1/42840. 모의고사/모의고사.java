import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        
        // 각 학생의 정답 수 계산
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) { 
                scores[0]++;
            }
            if (answers[i] == student2[i % student2.length]) { 
                scores[1]++;
            }
            if (answers[i] == student3[i % student3.length]) { 
                scores[2]++;
            }
        }
        
        // 최고 점수 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        // 최고 점수를 받은 학생 찾기
        List<Integer> winners = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                winners.add(i + 1);
            }
        }
        
        // 결과를 배열로 변환
        return winners.stream().mapToInt(i -> i).toArray();
    }
}