package Baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ConferenceRoomAllocate_1931 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int conferenceNum = 0;

        conferenceNum = inputParameter.nextInt();

        int[][] conferenceTime = new int[conferenceNum][2];

        for(int i = 0; i < conferenceNum; i++) {
            conferenceTime[i][0] = inputParameter.nextInt();
            conferenceTime[i][1] = inputParameter.nextInt();
        }

        System.out.println( calMaxConferenceNum(conferenceNum, conferenceTime) );
    }

    public static int calMaxConferenceNum(int conferenceNum, int[][] conferenceTime) {
        Arrays.sort(conferenceTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
                //start[0], end[0] 배열은 arr[][] 의 첫번째 라인(시작시간)이다.
                //start[1], end[0] 배열은 arr[][] 의 두번째 라인(종료시간)이다.
                if(start[1] == end[1]){
                    //만약 비교하는 값의 종료시간이 같을 경우 시작시간으로 정렬한다.
                    return Integer.compare(start[0], end[0]);
                }
                //종료시간에 따라 정렬한다.
                return Integer.compare(start[1], end[1]);
            }

        });

        int maxConferenceNum = 0;
        int end = -1;    // 다음시작 시간과 비교할 변수
        for (int i = 0; i < conferenceNum; i++) {
            //현재 시작시간이 이전 종료시간보다 늦을 경우
            if (conferenceTime[i][0] >= end) {
                //System.out.println(arr[i][0] + " " + arr[i][1]);
                end = conferenceTime[i][1];    //현재 종료시간을 다음 시작시간과 비교하기위해 저장
                maxConferenceNum++;
            }
        }

        return maxConferenceNum;
    }
}
