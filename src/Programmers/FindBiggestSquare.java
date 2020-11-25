package Programmers;

// dynamic programming
public class FindBiggestSquare {
    public int solution(int[][] board) {
        // 1, 0으로 채워진 board에서 가장 큰 정사각형의 넓이 return

        int answer = 0;

        int up, left, upleft;
		for(int y = 1 ; y < board.length; y++) {
			for(int x = 1 ; x < board[y].length; x++) {
				if(board[y][x] == 1) {
					up = board[y-1][x];
					left = board[y][x-1];
					upleft = board[y-1][x-1];

					int min = Math.min(up, left);
					min = Math.min(min , upleft);
					board[y][x] = min+1;
				}
			}
		}

		for(int y = 0 ; y < board.length; y++) {
			for(int x= 0 ; x < board[0].length ; x++) {
				if(board[y][x] > 0) {
					answer = Math.max(answer, board[y][x]);
				}
			}
		}

		return answer*answer;
    }
}
