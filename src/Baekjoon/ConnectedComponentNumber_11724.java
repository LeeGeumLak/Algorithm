package Baekjoon;

import java.util.Scanner;

public class ConnectedComponentNumber_11724 {
    static int N, M;
    static int[][] graph;
    static int[] visit;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();
        M = inputParameter.nextInt();

        visit = new int[N+1];
        graph = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            int x = inputParameter.nextInt();
            int y = inputParameter.nextInt();

            graph[x][y] = graph[y][x] = 1;
        }

        int count = 1;
        for(int i = 1; i <= N; i++) {
            if(visit[i] == 0) {
                DFS(i, count);

                count++;
            }
        }

        System.out.println(count - 1);
    }

    static void DFS(int x, int count) {
        visit[x] = count;

        for(int i = 1; i < N+1; i++) {
            if(graph[x][i] == 1 && visit[i] == 0) {
                DFS(i, count);
            }
        }
    }
}
