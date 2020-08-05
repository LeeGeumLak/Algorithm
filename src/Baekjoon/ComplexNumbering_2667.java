package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ComplexNumbering_2667 {
    static int N, count;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int[][] visited;

    static ArrayList complexList = new ArrayList();

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();

        map = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            String mapElement = inputParameter.next(); //붙어서 입력되기 때문에 다음 공백까지 받아오는 .next() 사용
            for(int j = 0; j < N; j++) {
                map[i][j] = (int)mapElement.charAt(j) - 48; //아스키코드값 변환
            }
        }

        /*for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print( map[i][j] );
            }
            System.out.println();
        }*/

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                if(map[i][j] == 1 && visited[i][j] == 0) {
                    count = 1;
                    bfs(i, j);
                    complexList.add(count);
                }
        }

        Collections.sort(complexList); // 오름차순 정렬

        System.out.println(complexList.size());

        for(int i = 0; i < complexList.size(); i++) {
            System.out.println(complexList.get(i));
        }

    }

    public static int bfs(int x, int y) {
        visited[x][y] = 1;

        for(int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N) {
                if(map[nx][ny] == 1 && visited[nx][ny] == 0)
                {
                    bfs(nx, ny);
                    count++;
                }
            }
        }
        return count;
    }
}
