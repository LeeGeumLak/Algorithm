package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideNSeek_1697 {
    static int N;
    static int K;
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();
        K = inputParameter.nextInt();

        bfs();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            N = q.poll();

            if(N == K) {
                break;
            }

            if(N+1 <= 100000 && visited[N+1] == 0) {
                q.add(N+1);
                visited[N+1] = visited[N] + 1;
            }

            if(N-1 >= 0 && visited[N-1] == 0) {
                q.add(N-1);
                visited[N-1] = visited[N] + 1;
            }

            if(N*2 <= 100000 && visited[N*2] == 0) {
                q.add(N*2);
                visited[N*2] = visited[N] + 1;
            }
        }

        System.out.println(visited[K] - 1);
    }
}
