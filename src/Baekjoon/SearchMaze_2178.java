package Baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchMaze_2178 {
    static int N, M;
    static int[] dx = {0, 1, 0, -1}; //상우하좌
    static int[] dy = {1, 0, -1, 0};
    static int[][] maze; //미로
    static boolean[][] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        maze = new int[N][M];
        checked = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String mazeElement = sc.next(); //붙어서 입력되기 때문에 다음 공백까지 받아오는 .next() 사용
            for(int j = 0; j < M; j++) {
                maze[i][j] = (int)mazeElement.charAt(j) - 48; //아스키코드값 변환
            }
        }

        bfs();
        System.out.print( maze[N - 1][M - 1] ); //(N, M) 출력. 좌표값이기 때문에 -1
    }

    public static void bfs() {
        Queue<Integer> queueX = new LinkedList<Integer>(); //x값에 대한 Queue
        Queue<Integer> queueY = new LinkedList<Integer>(); //y값에 대한 Queue

        queueX.offer(0);
        queueY.offer(0);

        checked[0][0] = true;

        while(!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            //상하좌우 확인
            for(int i = 0; i < 4; i++) {
                int checkX = x + dx[i];
                int checkY = y + dy[i];

                //유효한 범위인지 확인
                if(checkX >= 0 && checkY >= 0 && checkX < N && checkY < M) {
                    if(maze[checkX][checkY] == 1 && checked[checkX][checkY] == false) {
                        queueX.offer(checkX);
                        queueY.offer(checkY);

                        checked[checkX][checkY] = true;

                        maze[checkX][checkY] = maze[x][y] + 1; //이동횟수
                    }
                }
            }
        }
    }
}
