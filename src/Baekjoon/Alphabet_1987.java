package Baekjoon;

import java.util.Scanner;

public class Alphabet_1987 {
    static int R, C;
    static int[][] board;
    static boolean[] visited = new boolean[26];
    static int maxMoveArea = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) {
        // 세로 R칸, 가로 C칸인 보드 -> 각 칸에는 대문자 알파벳 하나씩 / 1행 1열에는 말이 있음
        // 말 이동 : 상하좌우, 지나왔던 곳의 알파벳과 같은 곳으로 이동 X
        // 최대한 몇 칸 지날 수 있는지

        Scanner inputParameter = new Scanner(System.in);

        R = inputParameter.nextInt();
        C = inputParameter.nextInt();
        board = new int[R][C];

        for(int i = 0; i < R; i++) {
            String str = inputParameter.next();
            for(int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);

        System.out.println(maxMoveArea);
    }

    public static void dfs(int x, int y, int count) {
        if (visited[board[x][y]]) {
            maxMoveArea = Math.max(maxMoveArea, count);
        }
        else {
            visited[board[x][y]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    dfs(nx, ny, count + 1);
                }
            }

            visited[board[x][y]] = false;
        }
    }
}
