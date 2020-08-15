package Baekjoon;

import java.util.Scanner;

public class WhiteSpace_1100 {
    static char[][] chessBoard = new char[8][8];
    static int count = 0;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        for(int i = 0; i < 8; i++) {
            String str = inputParameter.nextLine();
            for(int j = 0; j < 8; j++) {
                chessBoard[i][j] = str.charAt(j);

                if( chessBoard[i][j] == 'F' && (i+j) % 2 == 0 ) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
