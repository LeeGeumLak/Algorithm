package Baekjoon;

import java.util.Scanner;

//DFS
public class CalculateArea_2583 {
    static int M, N, K;
    static int[][] plottingPaper;
    static boolean[][] visited;

    static int areaCount = 0;
    static int[] areaSize;

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

            for(int j = squareX_1; j <= squareX_2; j++) {
                for(int k = squareY_1; k <= squareY_2; k++) {
                    plottingPaper[j][k] = 1;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {

            }
        }

    }

    public static void dfs() {

    }
}
