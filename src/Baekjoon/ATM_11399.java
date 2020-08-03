package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int peopleNum = 0; // 사람 수
        peopleNum = inputParameter.nextInt();


        int[] teskTime = new int[peopleNum]; // 각 사람 마다의 소요 시간
        for(int i = 0; i < peopleNum; i++) {
            teskTime[i] = inputParameter.nextInt();
        }

        System.out.println( calMinTeskTime(peopleNum, teskTime) );
    }

    public static int calMinTeskTime(int peopleNum, int[] testTime) {
        int totalTeskTime = 0; // 총 소요 시간
        int waitingTime = 0; // 대기 시간

        Arrays.sort(testTime); // 오름차순으로 정렬

        for(int i = 0; i < peopleNum; i++) {
            waitingTime += testTime[i];
            totalTeskTime += waitingTime;
        }

        return totalTeskTime;
    }
}
