package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class OrganicCabbage_1012 {
    static int T, M, N, K;
    static int[] count;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        T = inputParameter.nextInt();
        count = new int[T];
        for(int t = 0; t < T; t++) {
            M = inputParameter.nextInt();
            N = inputParameter.nextInt();
            K = inputParameter.nextInt();

            count[t] = 0;
            map = new int[N][M];

            for (int i = 0; i < K; i++) {
                int x = inputParameter.nextInt();
                int y = inputParameter.nextInt();

                map[y][x] = 1;
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] != 0) {
                        DFS(i, j);

                        count[t]++;
                    }
                }
            }
        }

        for(int i = 0; i < T; i++) {
            System.out.println(count[i]);
        }
    }

    public static void DFS(int X, int Y) {
        for(int i = 0; i < 4; i++) {
            int nextX = X + dx[i];
            int nextY = Y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }

            if(map[nextX][nextY] == 0) {
                continue;
            }

            map[nextX][nextY] = 0;
            DFS(nextX, nextY);
        }
    }
}
