package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoFriendsColoringBook {
    static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, -1, 0, 0}; // 남, 북, 동, 서
    static int[] dy = {0, 0, 1, -1};

    static Queue<Point> queue = new LinkedList<Point>();

    static boolean[][] visited;
    static int pictureSize = 0;

    public int[] solution(int m, int n, int[][] picture) {
        // 그림의 난이도를 영역의 수로 정의 (영억 : 상하좌우로 연결된 같은 색상의 공간)
        // 그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하기
        // 입력 : 1. m, n (세로길이, 가로길이)
        //       2. m x n 공간의 원소 (0은 색칠하지 않은 영역)
        // 출력 : [전체 색상 영역, 가장 큰 영역의 칸 수]

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] > 0 && !visited[i][j]){
                    pictureSize = 1;
                    bfs(picture, i, j, m, n);

                    numberOfArea++;
                    if(maxSizeOfOneArea < pictureSize)
                        maxSizeOfOneArea = pictureSize;
                }

            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    static void bfs(int[][] picture, int x, int y, int m, int n){
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];

                if(0 <= nx && nx < m && 0 <= ny && ny < n){
                    if(picture[nx][ny] == picture[x][y] && !visited[nx][ny]){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        pictureSize++;
                    }
                }
            }
        }
    }
}
