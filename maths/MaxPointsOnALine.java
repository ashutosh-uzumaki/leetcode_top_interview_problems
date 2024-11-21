package maths;

public class MaxPointsOnALine {
    class Solution {
        public int maxPoints(int[][] points) {
            int maxCnt = Integer.MIN_VALUE;
            if(points.length == 1){
                return 1;
            }
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    String slopeXY = findSlope(points[i], points[j]); 
                    int cnt = 2;
    
                    for (int k = 0; k < points.length; k++) {
                        if (k != i && k != j) {
                            String slopeXZ = findSlope(points[i], points[k]); 
                            if (slopeXY.equals(slopeXZ)) {
                                cnt++;
                            }
                        }
                    }
                    maxCnt = Math.max(cnt, maxCnt);
                }
            }
            return maxCnt;
        }
    
        public String findSlope(int[] pointA, int[] pointB) {
            int x1 = pointA[0];
            int y1 = pointA[1];
            int x2 = pointB[0];
            int y2 = pointB[1];
    
            if (x2 == x1) {
                return "vertical";
            } else if (y2 == y1) {
                return "0";
            } else {
    
                int deltaX = x2 - x1;
                int deltaY = y2 - y1;
                int gcd = gcd(deltaX, deltaY);
                
                
                return (deltaY / gcd) + "/" + (deltaX / gcd);
            }
        }
    
        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }
    
}
