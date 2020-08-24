package Baekjoon;

import java.util.Scanner;

public class DeliverySugar_2839 {
    static int N;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();

        if( N%5 == 0 ) { // N = 5*x
            System.out.println(N/5);
            return;
        }
        else { // N = 5*x + 3*y
            for(int i = N/5; i >0; i--) {
                if( (N-(i*5))%3 == 0 ) {
                    System.out.println(i+((N-(i*5))/3));
                    return;
                }
            }
        }

        if( N%3 == 0 ) { // N = 3*x
            System.out.println(N/3);
        }
        else { // null
            System.out.println(-1);
        }
    }
}
