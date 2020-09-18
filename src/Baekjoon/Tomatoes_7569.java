package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class threePoint {
    int x;
    int y;
    int z;

    public threePoint(int x,int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Tomatoes_7569 {
    static int M, N, H;

    static int[][][] tomatoBox;
    static int[][][] checkDay;

    static Queue<threePoint> queue = new LinkedList<threePoint>();

    // 동서남북 + 상/하
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        M = inputParameter.nextInt();
        N = inputParameter.nextInt();
        H = inputParameter.nextInt();

        tomatoBox = new int[H][N][M];
        checkDay = new int[H][N][M];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    tomatoBox[i][j][k] = inputParameter.nextInt();

                    if(tomatoBox[i][j][k] == 1) {
                        queue.add(new threePoint(i, j, k));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            threePoint startPoint = queue.remove();
            int x = startPoint.x;
            int y = startPoint.y;
            int z = startPoint.z;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (0 <= nx && nx < H && 0 <= ny && ny < N && 0 <= nz && nz < M) {
                    if (tomatoBox[nx][ny][nz] == 0 && checkDay[nx][ny][nz] == 0) {
                        queue.add(new threePoint(nx, ny, nz));
                        checkDay[nx][ny][nz] = checkDay[x][y][z] + 1;
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (ans < checkDay[i][j][k])
                        ans = checkDay[i][j][k];
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoBox[i][j][k] == 0 && checkDay[i][j][k] == 0) {
                        ans = -1;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
