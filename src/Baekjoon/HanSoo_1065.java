package Baekjoon;

import java.util.Scanner;

public class HanSoo_1065 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int N = inputParameter.nextInt();
        int result = 99;

        if(N < 100) {
            System.out.println(N);
        }
        else {
            for(int i = 100; i <= N; i++) {
                int hundredNumber = ( i / 100 ) % 10;
                int tenNumber = ( i / 10 ) % 10;
                int oneNumber = i % 10;

                if(tenNumber * 2 == hundredNumber + oneNumber) {
                    result++;
                }
            }
            if(N == 1000) {
                result--;
            }
            System.out.println(result);
        }
    }
}
