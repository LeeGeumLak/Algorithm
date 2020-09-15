package Baekjoon;

import java.util.Scanner;

public class ClimbingStairs_2579 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int stairNum = inputParameter.nextInt(); // 계단의 개수
        int[] stairScore = new int[stairNum+1]; // 각 계단의 점수 배열
        int[] totalScore = new int[stairNum+1]; // 올라온 계단들의 점수 합계

        // 각 배열에 점수 입력
        for(int i = 0; i < stairNum; i++) {
            stairScore[i] = inputParameter.nextInt();
        }

        // 입력 확인 테스트
        /*System.out.println(stairNum);
        for(int i = 0; i < stairNum; i++) {
            System.out.println(stairScore[i]);
        }*/

        // 계단이 1개나 2개만 있을 수 있음을 기억하자 -> 계단의 범위는 1~300
        if(stairNum == 1) {
            System.out.println(stairScore[0]);
        }
        else if(stairNum == 2) {
            System.out.println(Math.max(stairScore[0] + stairScore[1], stairScore[1]));
        }
        else {
            totalScore[0] = stairScore[0];
            totalScore[1] = Math.max(stairScore[1], stairScore[0] + stairScore[1]);
            totalScore[2] = Math.max(stairScore[1] + stairScore[2], stairScore[0] + stairScore[2]);


            // case 1. totalScore[i] = stairScore[i] + totalScore[i-2]
            // case 2. totalScore[i] = stairScore[i] + stairScore[i-1] + totalScore[i-3]
            for (int i = 3; i < stairNum; i++) {
                totalScore[i] = Math.max(stairScore[i] + totalScore[i - 2], stairScore[i] + stairScore[i - 1] + totalScore[i - 3]);
            }

            System.out.println(totalScore[stairNum - 1]);
        }
    }
}
