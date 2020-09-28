package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int y;
    int x;
    Point(int y, int x){
        this.y = y;
        this.x = x;

    }
}

public class RedGreenColorWeakness_10026 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static boolean[][] checkVisited;

    static int N;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();

        char[][] gridNormal = new char[N][N];
        char[][] gridWeakness = new char[N][N];

        checkVisited = new boolean[N][N];

        int normalCount = 0;
        int weaknessCount = 0;

        // 입력 버퍼 비움
        inputParameter.nextLine();

        // 그리드 초기화
        for(int i = 0; i < N; i++) {
            String RGBString = inputParameter.nextLine();
            for(int j = 0; j < N; j++) {
                char RGBChar = RGBString.charAt(j);
                if(RGBChar=='G') {
                    gridNormal[i][j] = RGBChar;
                    gridWeakness[i][j] = 'R';
                }else {
                    gridNormal[i][j] = RGBChar;
                    gridWeakness[i][j] = RGBChar;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!checkVisited[i][j]) {
                    bfs(i, j, gridNormal);
                    normalCount++;
                }
            }
        }

        // 방문 체크 배열 초기화
        checkVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!checkVisited[i][j]) {
                    bfs(i, j, gridWeakness);
                    weaknessCount++;
                }
            }
        }

        System.out.println(normalCount + " " + weaknessCount);
    }

    public static void bfs(int i, int j, char[][] grid) {
        Queue<Point> queue = new LinkedList<Point>();
        char ch = grid[i][j];

        queue.add(new Point(j,i));

        checkVisited[i][j] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(0 <= nx && nx < N && 0 <= ny && ny < N && !checkVisited[ny][nx]) {
                    if(!checkVisited[ny][nx] && grid[ny][nx] == ch) {
                        checkVisited[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
