class Solution {
    // 상하좌우 이동을 위한 방향 배열
    private final int[] dx = {-1, 1, 0, 0};  // 상하
    private final int[] dy = {0, 0, -1, 1};  // 좌우
    private final int[][] diagonals = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // 대각선
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int room = 0; room < places.length; room++) {
            answer[room] = isDistancingFollowed(places[room]) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean isDistancingFollowed(String[] room) {
        char[][] roomArray = new char[5][5];
        // 문자열 배열을 2차원 char 배열로 변환
        for (int i = 0; i < 5; i++) {
            roomArray[i] = room[i].toCharArray();
        }
        
        // 각 응시자의 위치에서 거리두기 확인
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (roomArray[i][j] == 'P') {
                    if (!checkDistance(i, j, roomArray)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean checkDistance(int x, int y, char[][] room) {
        // 상하좌우 맨해튼 거리 1 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (room[nx][ny] == 'P') return false;
            }
        }

        // 맨해튼 거리 2인 위치 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * 2;
            int ny = y + dy[i] * 2;

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (room[nx][ny] == 'P') {
                    // 직선 거리 2인 경우 중간 파티션 확인
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (room[mx][my] != 'X') return false;
                }
            }
        }

        // 대각선 위치 확인
        for (int[] d : diagonals) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (room[nx][ny] == 'P') {
                    // 대각선 경로에서 파티션 확인
                    if (room[x + d[0]][y] != 'X' || room[x][y + d[1]] != 'X') 
                        return false;
                }
            }
        }

        return true;
    }

}