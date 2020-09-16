package Baekjoon;

import java.util.Scanner;

public class WineTasting_2156 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int n = inputParameter.nextInt(); // 와인잔의 개수

        int[] wineAmount = new int[n+1]; // 각 와인잔에 담긴 와인의 양을 저장할 배열
        int[] dp = new int[n+1];

        // 배열에 각 와인잔에 담긴 와인의 양 입력
        wineAmount[0] = 0;
        for(int i = 1; i <= n; i++) {
            wineAmount[i] = inputParameter.nextInt();
        }

        // 다이나믹 프로그래밍을 풀 때는 항상 발생가능한 case를 따져보자
        // case 1. oox : dp[i] = dp[i-1]
        // case 2. oxo : dp[i] = wineAmount[i] + dp[i-2]
        // case 3. xoo : dp[i] = wineAmount[i] + wineAmount[i-1] + dp[i-3]

        dp[0] = wineAmount[0];
        if(n == 1) {
            dp[1] = wineAmount[1];
        }
        else if(n == 2) {
            dp[2] = wineAmount[2] + wineAmount[1];
        }
        else {
            dp[1] = wineAmount[1];
            dp[2] = wineAmount[2] + wineAmount[1];

            for(int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i-1], Math.max(wineAmount[i] + dp[i-2], wineAmount[i] + wineAmount[i-1] + dp[i-3]));
            }
        }

        System.out.println(dp[n]);
    }
}
