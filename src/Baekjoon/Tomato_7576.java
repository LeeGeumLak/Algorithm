package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato_7576 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int M = inputParameter.nextInt();
        int N = inputParameter.nextInt();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] box = new int[N][M];

        Queue<Dot> q = new LinkedList<Dot>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                box[i][j] = inputParameter.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 1) {
                    q.add(new Dot(i,j));
                }
            }
        }

        while(!q.isEmpty()) {
            Dot dot = q.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if(box[nextX][nextY] != 0) {
                    continue;
                }

                box[nextX][nextY] = box[dot.x][dot.y] + 1;
                q.add(new Dot(nextX, nextY));
            }
        }

        int max = box[0][0];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }else if(max < box[i][j]) {
                    max = box[i][j];
                }
            }
        }

        System.out.println(max-1);
    }
}

class Dot {
    int x, y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
