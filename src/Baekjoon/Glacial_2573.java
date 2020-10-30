package Baekjoon;

import java.util.Scanner;

// dfs
public class Glacial_2573 {
    static int N, M;
    static int year = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] glacialArray;
    static int[][] glacialMelt;
    static int[][] visited;

    public static void main(String[] args) {
        // 빙산을 2차원 배열에 표시, 각 부분별 높이가 저장됨
        // 아무것도 안적힌 부분은 0
        // 각 빙산 칸은 매년 주위 0의 개수만큼 높이가 줄어듦
        // 한 덩어리의 빙하가 주어질 때, 두 덩어리 이상으로 분리되는 최초의 연도 구하기
        // 단, 다 녹을 때까지 분리가 안되면 0 출력
        // 입력 : 1. 배열의 행(N), 열(M)
        //       2. 빙산의 높이 정보
        // 출력 : 연도

        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();
        M = inputParameter.nextInt();

        visited = new int[N][M];
        glacialMelt = new int[N][M];
        glacialArray = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                glacialArray[i][j] = inputParameter.nextInt();
            }
        }

        while(true) {
            int glacialPieces = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(visited[i][j] == 0 && glacialArray[i][j] != 0) {
                        dfs(i, j);
                        glacialPieces++;
                    }
                }
            }

            if(glacialPieces == 0) {
                System.out.println(0);
                return;
            }
            else if(glacialPieces >= 2) {
                break;
            }

            melting();
            year++;
        }

        System.out.println(year);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = 1;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                // 1년 후에 녹는 빙산의 양 구하기
                if(glacialArray[nx][ny] == 0) {
                    glacialMelt[x][y]++;
                }

                if(visited[nx][ny] == 0 && glacialArray[nx][ny] != 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void melting() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                glacialArray[i][j] -= glacialMelt[i][j];

                if(glacialArray[i][j] < 0) {
                    glacialArray[i][j] = 0;
                }

                visited[i][j] = 0;
                glacialMelt[i][j] = 0;
            }
        }
    }
}
