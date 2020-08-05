package Baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS_1260 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int N = inputParameter.nextInt(); // 정점의 개수
        int M = inputParameter.nextInt(); // 간선의 개수
        int V = inputParameter.nextInt(); // 시작 점의 번호

        int[][] map = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            Arrays.fill(map[i], 0);
        }

        boolean[] isVisited = new boolean[N+1]; // 정점 방문 여부
        Arrays.fill(isVisited, false);

        for(int i = 0; i < M; i++) {
            int row = inputParameter.nextInt();
            int column = inputParameter.nextInt();

            map[row][column] = 1;
            map[column][row] = 1;
        }

        DFS(N, map, V, isVisited);

        System.out.println(); // 엔터
        Arrays.fill(isVisited, false); // 정점 방문 여부 초기화

        BFS(N, map, V, isVisited);
    }

    public static void DFS(int N, int[][] map, int V, boolean[] isVisited) {
        isVisited[V] = true;

        System.out.print(V + " ");
        for(int i = 0; i < N+1; i++) {
            if( map[V][i] == 1 && isVisited[i] == false ) {
                DFS(N, map, i, isVisited);
            }
        }
    }

    public static void BFS(int N, int[][] map, int V, boolean[] isVisited) {
        Queue<Integer> bfsQueue = new LinkedList<Integer>();

        bfsQueue.offer(V);
        isVisited[V] = true;

        while(!bfsQueue.isEmpty()) {
            int firstPoint = bfsQueue.poll();

            System.out.print(firstPoint + " ");

            for(int i = 1; i <= N; i++) {
                if( map[firstPoint][i] == 1 && isVisited[i] == false ) {
                    bfsQueue.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }

}
