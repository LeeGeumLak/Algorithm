package Baekjoon;

import java.util.Scanner;

public class RGB_Street_1149 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int testCase = inputParameter.nextInt();
        int[][] paintPrice = new int[testCase][3];

        for(int i = 0; i < testCase; i++) {
            paintPrice[i][0] = inputParameter.nextInt();
            paintPrice[i][1] = inputParameter.nextInt();
            paintPrice[i][2] = inputParameter.nextInt();
        }

        int[][] output = new int[testCase][3];
        output[0][0] = paintPrice[0][0];
        output[0][1] = paintPrice[0][1];
        output[0][2] = paintPrice[0][2];

        for(int i = 1; i < testCase; i++) {
            output[i][0] = Math.min(output[i-1][1], output[i-1][2]) + paintPrice[i][0];
            output[i][1] = Math.min(output[i-1][0], output[i-1][2]) + paintPrice[i][1];
            output[i][2] = Math.min(output[i-1][0], output[i-1][1]) + paintPrice[i][2];
        }

        System.out.println(Math.min(Math.min(output[testCase-1][0], output[testCase-1][1]), output[testCase-1][2]));
    }
}
