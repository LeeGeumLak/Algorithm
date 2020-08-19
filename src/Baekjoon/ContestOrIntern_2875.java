package Baekjoon;

import java.util.Scanner;

public class ContestOrIntern_2875 {
    static int N, M, K, result;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();
        M = inputParameter.nextInt();
        K = inputParameter.nextInt();

        result = Math.min(N / 2, M);
        K -= N + M - result*3;

        while(K > 0) {
            K -= 3;
            result--;
        }

        System.out.println(result);
    }
}
