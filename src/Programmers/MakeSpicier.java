package Programmers;

import java.util.PriorityQueue;

public class MakeSpicier {
    public int solution(int[] scoville, int K) {
        // 스코빌 지수 K 이상으로 만들기
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞음
        // 입력 : 스코빌 지수를 저장한 scoville 배열 , 원하는 스코빌 지수 K
        // 출력 : 모든 음식의 스코빌 지수를 K 이상으로 만들기위한 최소 횟수

        int answer = 0;

        PriorityQueue<Integer> scovilleQueue = new PriorityQueue();

        for (int scovilleElement : scoville) {
            scovilleQueue.offer(scovilleElement);
        }

        while (scovilleQueue.peek() <= K) {
            if (scovilleQueue.size() == 1) {
                return -1;
            }
            int firstElement = scovilleQueue.poll();
            int secondElement = scovilleQueue.poll();


            int result = firstElement + (secondElement * 2);

            scovilleQueue.offer(result);
            answer ++;
        }
        return answer;
    }
}
