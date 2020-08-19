package Baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Junior_1946 {
    static int T, N;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        T = inputParameter.nextInt();
        int[] resultArray = new int[T];

        for(int t = 0; t < T; t++) {
            N = inputParameter.nextInt();
            int result = 1;
            int[][] juniorScore = new int[N+1][2];

            for(int i = 1; i <= N; i++) {
                for(int j = 0; j < 2; j++) {
                    juniorScore[i][j] = inputParameter.nextInt();
                }
            }

            Arrays.sort(juniorScore, new Comparator<int []>(){
                public int compare(int arr1[], int arr2[]) {
                    return Integer.compare(arr1[0], arr2[0]);
                }
            });

            int pivot = juniorScore[1][1];
            for(int i = 2; i <= N; i++) {
                if (juniorScore[i][1] < pivot) {
                    pivot = juniorScore[i][1];
                    result++;
                }
            }

            resultArray[t] = result;
        }

        for(int i = 0; i < T; i++) {
            System.out.println(resultArray[i]);
        }
    }
}
