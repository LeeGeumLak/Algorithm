package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Tuple {
    public int[] solution(String s) {
        // 셀수 있는 수량의 순서있는 시퀀스의 모음 : {a1, a2, a3, ... , an}
        // 중복 가능, 정해진 순서가 있고 순서가 다르면 다른 튜플
        // 특정 튜플을 표현하는 문자열 s 입력시, 해당 튜플을 배열에 담아 return

        Map<Integer, Integer> keyMap = new HashMap<>();
        Map<Integer, Integer> valueMap = new HashMap<>();

        // 중괄호 제거 후, 쉼표 기준으로 split
        String[] sArray = s.replace("{", "").replace("}", "").split(",");

        // 각 값들을 key, 개수를 value로 하는 keyMap 생성
        for (String str : sArray) {
            int key = Integer.parseInt(str);
            keyMap.compute(key, (k, v) -> v == null ? 1 : v + 1);
        }

        // keyMap을 value 기준으로 정렬하기 위한 valueMap 생성
        keyMap.forEach((k, v) -> valueMap.put(v, k));

        int n = valueMap.size();
        int[] answer = new int[n];

        // answer에 valueMap 값 입력
        for (int i = 1; i <= n; i++) {
            answer[n-i] = valueMap.get(i);
        }

        return answer;
    }
}
