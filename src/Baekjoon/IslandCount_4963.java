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
    // 지도 너비, 지도 높이, bfs 결과값
    static int w, h, islandCount = 0;

    // 동서남북
    static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
    static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };

    // 각 테스트 케이스의 결과값인 islandCount 값을 저장할 리스트
    static LinkedList<Integer> countBuffer = new LinkedList<>();
    
    static int[][] map;
    
    // 방문여부 체크 배열
    static int[][] checkVisited;

    public static void main(String[] args) {
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

                int count = 0;
                checkVisited = new int[h][w];

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (map[i][j] == 1 && checkVisited[i][j] == 0)
                            // dfs(i, j, ++count, w, h);
                            bfs(i, j, ++count, w, h);
                    }
                }

                countBuffer.add(islandCount);
            }

            islandCount = 0;
        }

        // 저장된 결과값 출력
        for(int i : countBuffer) {
            System.out.println(i);
        }
    }
    
    public static void bfs(int x, int y, int count, int w, int h) {
        Queue<Pairs> queue = new LinkedList<Pairs>();
        queue.add(new Pairs(x, y));
        checkVisited[x][y] = count;
        while (!queue.isEmpty()) {
            Pairs p = queue.remove();
            x = p.x;
            y = p.y;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (map[nx][ny] == 1 && checkVisited[nx][ny] == 0)
                        bfs(nx, ny, count, w, h);
                }
            }
        }
    }
}
