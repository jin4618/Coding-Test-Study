import java.util.*;

class Solution {
    private static class Point {
        public final long x, y;
        
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 교점 좌표 구하기
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1); 
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        
        if (x % 1 != 0 || y % 1 != 0) return null;  // 평행, 일치
        
        return new Point((long) x, (long) y);
    }
    
    // x, y 좌표 최솟값, 최댓값 구하기
    private Point getMinPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    private Point getMaxPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    public String[] solution(int[][] line) {
        // 정수 좌표만 저장
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < line.length; i++) {
            for(int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                                                 line[j][0], line[j][1], line[j][2]);
                if(intersection != null) {
                    points.add(intersection);
                }
            }
        }
        
        // x, y 좌표 최솟값, 최댓값 구해서 2차원 배열 크기 결정
        Point min = getMinPoint(points);
        Point max = getMaxPoint(points);
        
        int width = (int) (max.x - min.x + 1);
        int height = (int) (max.y - min.y + 1);
        
        char[][] arr = new char[height][width]; // 좌표 문자로 표시
        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        // 2차원 배열에 별 찍기
        for(Point p : points) {
            int x = (int) (p.x - min.x);
            int y = (int) (max.y - p.y);
            arr[y][x] = '*';
        }
        
        // 문자열 배열로 변환 후 반환
        String[] result = new String[arr.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        
        return result;
    }
}