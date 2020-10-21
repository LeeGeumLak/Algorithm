package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 중요도가 높은 문서를 먼저 인쇄하는 프린터
        // 1. 가장 처음 대기 문서 저장
        // 2. 저장한 문서보다 높은 중요도 있으면, 이 문서를 배열 가장 마지막으로
        // 3. 저장한 문서가 가장 중요도가 높으면 인쇄
        // 입력 : 1. 대기중인 문서의 중요도
        //       2. 요청한 문서의 idx
        // 출력 : 몇번재로 인쇄되는지

        // PriorityQueue? FIFO가 아닌 일정한 규칙에 따라 우선순위를 정하여 출력함 (최소값 기준)
        // Collections.reverseOrder()? 배열 역순으로 정렬 (default : 최소값 기준 정렬)
        PriorityQueue<Integer> prioritiesQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < priorities.length; i++) {
            prioritiesQueue.offer(priorities[i]);
        }

        // 높은 우선 순위가 있으면 출력하고, 개수 출력
        while( !prioritiesQueue.isEmpty() ) {
            for(int i = 0; i < priorities.length; i++) {
                if( prioritiesQueue.peek() == priorities[i] ) {
                    prioritiesQueue.poll();
                    answer++;

                    if(location == i) {
                        prioritiesQueue.clear();
                        break;
                    }
                }

            }
        }

        return answer;
    }
}
