package Programmers;

import java.util.HashMap;
import java.util.Set;

public class Camouflage {
    public int solution(String[][] clothes) {
        // 스파이 옷 입기
        // 적어도 한 종류의 옷을 입어야함
        // 가지고 있는 옷으로 입을 수 있는 조합의 개수
        // 입력 : {가지고 있는 옷의 이름, 해당 옷의 종류} 조합으로 이루어진 문자열 배열
        // 출력 : 가지고 있는 옷으로 입을 수 있는 조합의 개수

        int answer = 0;

        // String : 의상 종류, Integer : 개수
        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();

        for(int i = 0; i < clothes.length; i++){
            //의상종류, 갯수
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
            // getOrDefault : 키(의상종류)에 해당하는 값의 개수( 없으면 0 )
        }

        //조합
        Set<String> keySet = clothesMap.keySet(); //의상종류.

        answer++;
        for(String key : keySet) {
            answer *= clothesMap.get(key)+1;
        }

        return answer-1; //아무것도 안입는 경우의 수 제거
    }
}
