package Programmers;

import java.util.Arrays;

public class SafetyBoat {
    public int solution(int[] people, int limit) {
        // 한 번에 최대 2명씩 탈 수 있는 구명보트 + 무게제한(limit)
        // 구명보트를 최소로 사용하여 모든 사람 구출
        // 입력 : 사람들의 몸무게를 담은 people 배열 , 구명보트의 무게 제한 limit
        // 출력 : 필요한 보트의 최솟값

        int answer = 0;

        Arrays.sort(people);

        int min = 0;
        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
}
