package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus_2606 {
    static int[][] graph;
    static int[] check;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int computerNumber = inputParameter.nextInt();
        int pairNumber = inputParameter.nextInt();

        graph = new int[computerNumber + 1][computerNumber + 1];
        check = new int[computerNumber + 1];

        for(int i = 0; i < pairNumber; i++) {
            int a = inputParameter.nextInt();
            int b = inputParameter.nextInt();

            graph[a][b] = graph[b][a] = 1;
        }

        bfs(1);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();

        check[start] = 1;
        queue.offer(start);

        int cnt = 0; // 감염 된 컴퓨터의 수
        while(!queue.isEmpty()) {
            int x = queue.poll();

            for(int i = 1; i < graph.length; i++) { // 차례대로 1번과 연결 된 컴퓨터들을 찾아 cnt변수 증가
                if( graph[x][i] == 1 && check[i] != 1 ) {
                    queue.offer(i);
                    check[i] = 1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt); //모든 탐색을 마치고 cnt 출력
    }
}
