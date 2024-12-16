class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;    // 공원 세로
        int w = park[0].length();   // 공원 가로
        // 시작 위치 좌표
        int x = 0;
        int y = 0;
        
        // 시작 위치 S 찾기
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        // 방향, 이동거리 정의
        int[] dx = {-1, 1, 0, 0};   // N, S, W, E 방향에 따른 x 변화
        int[] dy = {0, 0, -1, 1};   // N, S, W, E 방향에 따른 y 변화
        String directions = "NSWE";
        
        // 명령 수행
        for(String route : routes) {
            String[] parts = route.split(" ");
            char direction = parts[0].charAt(0);
            int distance = Integer.parseInt(parts[1]);
            
            int dirIndex = directions.indexOf(direction);
            int nx = x, ny = y;
            boolean isBlocked = false;
            
            // 이동 거리만큼 시뮬레이션
            for(int step = 0; step < distance; step++) {
                nx += dx[dirIndex];
                ny += dy[dirIndex];
                
                // 공원을 벗어나거나 장애물 만날 경우 무시
                if(nx < 0 || ny < 0 || nx >= h || ny >= w || park[nx].charAt(ny) == 'X') {
                    isBlocked = true;
                    break;
                }
            }
            
            // 이동 가능하면
            if(!isBlocked) {
                x = nx;
                y = ny;
            }
        }
        
        return new int[] {x, y};
    }
}