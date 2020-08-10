package Baekjoon;

import java.util.Scanner;

public class PathFinding_11403 {
    static int N;
    static int[][] graph;
    static int[][] result;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();

        result = new int[N][N];
        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = inputParameter.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            int[] visit = new int[N];
            DFS(i, visit, true);
            result[i] = visit;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void DFS(int idx, int[] visit, boolean isFirst) {
        if(!isFirst) {
            visit[idx] = 1;
        }
        for(int i = 0; i < N; i++) {
            if(graph[idx][i] == 1 && visit[i] == 0) {
                DFS(i, visit, false);
            }
        }
    }
}
