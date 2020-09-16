package Baekjoon;

import java.util.Scanner;

public class PinaryNumber_2193 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int N = inputParameter.nextInt();
        long[] pinaryNumber = new long[N+1];

        // N = 1, 2, ... 초반 숫자들 대입해서 몇개인지 알아보기
        // dp[N][0] / dp[N][1] ==> 끝자리가 0 / 1 인 경우로 나누어 계산
        // case 1. N 번째 숫자가 0 일때, pinaryNumber[N] = pinaryNumber[N-1]
        // case 2. N 번째 숫자가 1 일때, pinaryNumber[N] = pinaryNumber[N-2]
        //                    ==> 총합 : pinaryNumber[N] = pinaryNumber[N-1] + pinaryNumber[N-2]
        pinaryNumber[0] = 0;
        pinaryNumber[1] = 1;

        for(int i = 2; i <= N; i++) {
            pinaryNumber[i] = pinaryNumber[i-1] + pinaryNumber[i-2];
        }

        System.out.println(pinaryNumber[N]);

    }
}
