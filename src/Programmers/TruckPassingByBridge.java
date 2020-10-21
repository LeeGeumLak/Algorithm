package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingByBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 모든 트럭이 다리를 건너려면 몇 초가 걸리는지
        // 트럭은 1초에 1만큼 움직임
        // 다리 길이 : bridge_length / 다리 허용 무게 : weight

        int[] arrivalTime = new int[truck_weights.length];
        Queue<Integer> passingTruckQueue = new LinkedList<Integer>();

        int currentTruckNum = 0;
        do {
            // 버스 도착
            if (!passingTruckQueue.isEmpty() && arrivalTime[passingTruckQueue.peek()] == answer) {
                weight += truck_weights[passingTruckQueue.poll()];
            }

            // 버스 출발
            if ((currentTruckNum < truck_weights.length) && (truck_weights[currentTruckNum] <= weight)) {
                passingTruckQueue.add(currentTruckNum);
                arrivalTime[currentTruckNum] = answer + bridge_length;
                weight -= truck_weights[currentTruckNum];
                currentTruckNum++;
            }

            answer++;

        } while (!passingTruckQueue.isEmpty());

        return answer;
    }
}
