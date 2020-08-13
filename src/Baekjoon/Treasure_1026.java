package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Treasure_1026 {
    static int N, S = 0;
    static int[] A, B;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();
        A = new int[N];
        B = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = inputParameter.nextInt();
        }
        for(int i = 0; i < N; i++) {
            B[i] = inputParameter.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < N; i++) {
            S += A[i] * B[N - 1 - i];
        }

        System.out.println(S);
    }
}
