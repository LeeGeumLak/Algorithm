package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point_7562 {
    int x;
    int y;

    public point_7562(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class KnightsMovement_7562 {
    static int[] dx = {-2,-1,2,1,2,1,-2,-1};
    static int[] dy = {1,2,1,2,-1,-2,-1,-2};

    static int[][] chessBoard;
    static boolean[][] visited;
    static int testCase, l, currentX, currentY, goalX, goalY;

    static Queue<point_7562> visitedQueue = new LinkedList<point_7562>();

    public static void main(String[] args) {
        // 체스판 나이트 이동
        // 입력 : 1. 테스트 케이스 (각 테스트 케이스는 3줄로 입력받음)
        //       2_1. 체스판 한 변의 길이 l (4 <= l <= 300) -> l x l
        //       2_2. 나이트가 현재 있는 칸
        //       2_3. 나이트가 이동하려는 칸
        // 출력 : 2_3 으로 가기 위해 이동해야하는 최소 칸

        Scanner inputParameter = new Scanner(System.in);

        testCase = inputParameter.nextInt();
        int[] resultArray = new int[testCase];

        for(int i = 0; i < testCase; i ++) {
            l = inputParameter.nextInt();
            chessBoard = new int[l][l];
            visited = new boolean[l][l];

            currentX = inputParameter.nextInt();
            currentY = inputParameter.nextInt();

            goalX = inputParameter.nextInt();
            goalY = inputParameter.nextInt();

            bfs(new point_7562(currentX, currentY));

            resultArray[i] = chessBoard[goalX][goalY];
        }

        for(int i = 0; i < testCase; i++) {
            System.out.println(resultArray[i]);
        }
    }

    public static void bfs(point_7562 p) {
        visitedQueue.clear();
        visited[p.x][p.y] = true;
        visitedQueue.add(p);

        while(!visitedQueue.isEmpty()) {
            point_7562 tempP = visitedQueue.remove();
            int tempX = tempP.x;
            int tempY = tempP.y;

            for (int i = 0; i < 8; i++) {
                int x = tempX + dx[i];
                int y = tempY + dy[i];

                if(x >= 0 && x < l && y >= 0 && y < l && !visited[x][y]) {
                    visitedQueue.add(new point_7562(x,y));
                    visited[x][y] = true;
                    //전의 이동 횟수에 +1 씩 더해주며 이동 횟수를 증가시켜준다.
                    chessBoard[x][y] = chessBoard[tempX][tempY] + 1;
                }

            }
        }
    }
}
