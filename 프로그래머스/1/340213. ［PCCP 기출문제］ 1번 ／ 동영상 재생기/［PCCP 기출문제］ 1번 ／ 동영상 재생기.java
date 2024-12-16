class Solution {
    // 문자열 시간 => 초 단위로
    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    // 오프닝 구간 체크
    private int skipOpening(int currentPos, int opStart, int opEnd) {
        if (currentPos >= opStart && currentPos <= opEnd) {
                return opEnd;
            }
        return currentPos;
    }

    // 초 단위 => "mm:ss"
    private String secondsToTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 모든 시간 => 초 단위로
        int videoLength = timeToSeconds(video_len);
        int currentPos = timeToSeconds(pos);
        int opStart = timeToSeconds(op_start);
        int opEnd = timeToSeconds(op_end);
        
        // 오프닝 건너뛰기
        currentPos = skipOpening(currentPos, opStart, opEnd);

        for (String command : commands) {
            // 명령어 처리
            if (command.equals("prev")) {
                currentPos = Math.max(0, currentPos - 10);
            } else if (command.equals("next")) {
                currentPos = Math.min(videoLength, currentPos + 10);
            }
            
            currentPos = skipOpening(currentPos, opStart, opEnd);
        }

        return secondsToTime(currentPos);
    }
}