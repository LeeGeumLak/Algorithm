package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point {
    int x;
    int y;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RedGreenColorWeakness_10026 {
    static int n;

    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int colorNormal = 0;
    static int colorWeakness = 0;

    static Queue<point> q = new LinkedList<point>();

    public static void main(String[] args) throws Exception{
        Scanner inputParameter = new Scanner(System.in);

        n = Integer.parseInt(inputParameter.nextLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            char[] str = inputParameter.nextLine().toCharArray();
            for(int j = 0; j < n; j++) {
                map[i][j] = str[j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(new point(i,j));
                    colorNormal++;
                }
            }
        }

        //다시 bfs를 해야 하므로, visited 초기화 ('R'을 'G'로 전환)
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(new point(i,j));
                    colorWeakness++;
                }
            }
        }

        System.out.println(colorNormal + " " + colorWeakness);
    }

    static void bfs(point d) {
        char color = map[d.x][d.y];
        visited[d.x][d.y] = true;
        q.add(d);

        while(!q.isEmpty()) {
            point t = q.remove();
            int x1 = t.x;
            int y1 = t.y;

            for(int i=0; i<4; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if(x2>=0 && x2<n && y2>=0 && y2<n && map[x2][y2] == color && !visited[x2][y2]) {
                    q.add(new point(x2,y2));
                    visited[x2][y2] = true;
                }

            }
        }
    }
}