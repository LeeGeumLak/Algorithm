package Baekjoon;

import java.util.Scanner;

public class IntegerTriangle_1932 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int n = inputParameter.nextInt(); // 삼각형의 크기
        int max = 0; // 최대값

        int[][] triangle = new int[n+1][n+1]; // 삼각형의 각 정수를 넣을 2차원 배열

        // 삼각형 최상단의 정수
        triangle[0][0] = inputParameter.nextInt();

        // 최대값 계산
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                // 정수값 받아옴
                triangle[i][j] = inputParameter.nextInt();

                // case 1. 시작 행 -> 바로 위의 정수와 합
                // case 2. 마지막 행 -> 대각선 위의 정수와 합
                // case 3. 나머지 행 -> 바로 위와 대각선 위의 정수 중 더 큰 값과 합
                // ==> max 계산해나가면서 결국 가장 마지막 행에서 최종 max 값 계산됨
                if(j == 0)
                    triangle[i][j] += triangle[i-1][j];
                else if(j == i)
                    triangle[i][j] += triangle[i-1][j-1];
                else
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);

                max = Math.max(max, triangle[i][j]);
            }
        }

        System.out.println(max);
    }
}
