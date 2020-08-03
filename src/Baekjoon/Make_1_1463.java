package Baekjoon;

import java.util.Scanner;

public class Make_1_1463 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int N = inputParameter.nextInt();
        int[] calCount = new int[N + 1];
        calCount[1] = 0;

        for(int i = 1; i <= N; i++) {
            if(i + 1 <= N) {
                if(calCount[i+1] == 0) {
                    calCount[i+1] = calCount[i] + 1;
                }
                else {
                    calCount[i+1] = Math.min(calCount[i]+1, calCount[i+1]);
                }
            }
            if(i * 3 <= N) {
                if(calCount[i * 3] == 0) {
                    calCount[i * 3] = calCount[i] + 1;
                }
                else {
                    calCount[i * 3] = Math.min(calCount[i]+1, calCount[i * 3]);
                }
            }
            if(i * 2 <= N) {
                if(calCount[i * 2] == 0) {
                    calCount[i * 2] = calCount[i] + 1;
                }
                else {
                    calCount[i * 2] = Math.min(calCount[i]+1, calCount[i * 2]);
                }
            }
        }

        System.out.println(calCount[N]);
    }
}
