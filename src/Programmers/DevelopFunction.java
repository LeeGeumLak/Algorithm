package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DevelopFunction {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        // 각 기능은 진도가 100%일 때, 서비스에 반영가능
        // 각 개발속도 다름 -> 뒤에 있는게 먼저 개발될 수 있으나, 배포는 앞의 기능과 함께
        // 입력 1 : 배포되어야하는 순서대로 작업 진도가 적힌 정수 배열
        // 입력 2 : 각 작업의 개발 속도가 적힌 배열 sppeds가 적힌 정수 배열
        // 각 배포마다 몇 개의 기능이 배포되는지

        // concurrentLinkedQueue? 멀티스레드 환경에서 작업을 병렬처리, 꺼낼 원소 없으면 즉시 리턴
        Queue<Integer> dayLeft = new ConcurrentLinkedQueue<Integer>();

        // dayLeft queue 초기화
        for(int i = 0; i < progresses.length; i++) {
            if( ( 100 - progresses[i] ) % speeds[i] == 0 ) {
                dayLeft.add( ( 100 - progresses[i] ) / speeds[i] );
            }
            else {
                dayLeft.add( ( 100 - progresses[i] ) / speeds[i] + 1 );
            }
        }

        int precedence = dayLeft.poll(); // 현재 선행작업
        int dateCounter = 1; // 날짜 카운터

        // 각 배포시, 완료된 기능 개수 저장 list
        List<Integer> answerList = new ArrayList<Integer>();

        while( !dayLeft.isEmpty() ) {
            int functionWorkDate = dayLeft.poll();

            if( precedence < functionWorkDate ) {
                answerList.add(dateCounter);
                dateCounter = 1;
                precedence = functionWorkDate;
            }
            else {
                dateCounter++;
            }
        }

        // 마지막 배포시, 완료된 기능 개수 저장
        answerList.add(dateCounter);

        answer = new int[ answerList.size() ];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
