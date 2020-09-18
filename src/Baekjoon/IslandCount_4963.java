package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pairs {
    int x;
    int y;

    Pairs(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class IslandCount_4963 {
    // 이동가능 방향 (동.서.남.북.대각선)
    static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
    static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };

    // 입력받을 지도 배열
    static int[][] map;
    
    // 방문여부 체크 배열
    static int[][] checkVisited;

    public static void main(String[] args) {
        int w, h; // 지도 너비, 높이

        // 각 테스트 케이스의 결과값인 islandCount 값을 저장할 리스트
        LinkedList<Integer> countBuffer = new LinkedList<>();

        Scanner inputParameter = new Scanner(System.in);

        boolean quit = false; // while문 탈출 조건 변수

        while(!quit) {
            w = inputParameter.nextInt(); // 지도 너비
            h = inputParameter.nextInt(); // 지도 높이

            // 방문여부체크 배열 초기화
            checkVisited = new int[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    checkVisited[i][j] = 0;
                }
            }

            // while문 탈출 확인 구문
            if( w == 0 && h == 0 ) {
                quit = true;
            }
            else if( w == 1 && h == 1 ) {
                if(inputParameter.nextInt() == 1) {
                    countBuffer.add(1);
                }
                else {
                    countBuffer.add(0);
                }
            }
            // 정상 입력시
            else {
                // 입력받을 지도
                map = new int[h][w];
                
                // 지도 입력
                for(int i = 0; i < h; i++) {
                    for(int j = 0; j < w; j++) {
                        map[i][j] = inputParameter.nextInt();
                    }
                }

                int islandCount = 0;
                checkVisited = new int[h][w];

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (map[i][j] == 1 && checkVisited[i][j] == 0) {
                            bfs(i, j, ++islandCount, w, h);
                        }
                    }
                }

                countBuffer.add(islandCount);
            }
        }

        // 저장된 결과값 출력
        for(Integer i : countBuffer) {
            System.out.println(i);
        }
    }
    
    public static void bfs(int x, int y, int islandCount, int w, int h) {
        Queue<Pairs> queue = new LinkedList<Pairs>();
        queue.add(new Pairs(x, y));
        checkVisited[x][y] = islandCount;
        while (!queue.isEmpty()) {
            Pairs p = queue.remove();
            x = p.x;
            y = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (map[nx][ny] == 1 && checkVisited[nx][ny] == 0)
                        bfs(nx, ny, islandCount, w, h);
                }
            }
        }
    }
}
