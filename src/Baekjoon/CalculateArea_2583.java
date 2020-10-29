package Baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CalculateArea_2583 {
    static int M, N, K;
    static int[][] plottingPaper;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int areaCount;
    static PriorityQueue<Integer> areaSizeQueue = new PriorityQueue<Integer>();


    public static void main(String[] args) {
        // M x N 모눈종이 -> K 개의 직사각형 그리기
        // 나머지 그려지지 않은 부분이 몇개의 영역으로 이루어져 있는지 + 각 영역의 넓이
        // 입력 : 1. M N K
        //       2. 각 직사각형의 대각선 좌표 2개 (K 줄)
        // 출력 : 1. 나눠지는 영역의 개수
        //       2. 각 영역의 넓이 (오름차순)

        Scanner inputParameter = new Scanner(System.in);
        M = inputParameter.nextInt();
        N = inputParameter.nextInt();
        K = inputParameter.nextInt();

        plottingPaper = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            int squareX_1 = inputParameter.nextInt();
            int squareY_1 = inputParameter.nextInt();
            int squareX_2 = inputParameter.nextInt();
            int squareY_2 = inputParameter.nextInt();

            for(int j = squareY_1; j < squareY_2; j++) {
                for(int k = squareX_1; k < squareX_2; k++) {
                    plottingPaper[j][k] = 1;
                }
            }
        }


        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                areaCount = 0;
                if(plottingPaper[i][j] == 0) {
                    dfs(i, j);
                    areaSizeQueue.offer(areaCount);
                }
            }
        }

        System.out.println(areaSizeQueue.size());
        while(!areaSizeQueue.isEmpty()) {
            System.out.print(areaSizeQueue.poll() + " ");
        }
    }

    public static void dfs(int x, int y) {
        plottingPaper[x][y] = 1;
        areaCount++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if(plottingPaper[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }

        }
    }
}
