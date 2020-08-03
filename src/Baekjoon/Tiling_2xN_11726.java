package Baekjoon;

import java.util.Scanner;

public class Tiling_2xN_11726 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int N = inputParameter.nextInt();
        int[] output = new int[N+1];

        output[0] = 1;
        output[1] = 1;

        for(int i = 2; i <= N; i++) {
            output[i] = output[i-1] + output[i-2];
            output[i] %= 10007;
        }

        System.out.println(output[N]);
    }
}
