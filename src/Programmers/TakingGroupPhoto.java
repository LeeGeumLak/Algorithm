package Programmers;

import java.util.*;

// dfs
public class TakingGroupPhoto {
    static HashMap<Character, Integer> characterMap;
    static int[] permutation;
    static boolean[] selected;
    static int answer;

    public int solution(int n, String[] data) {
        // 네오는 프로도와 나란히 서기를 원함
        // 라이언은 튜브에게서 적어도 세칸 이상 떨어지기를 원함
        // 입력받는 모든 조건을 만족할 수 있도록 서는 경우의 수 계산
        // 입력 : n (조건의 개수)
        //       n개로 구성된 문자열 배열 data

        // 순열 : 8개의 캐릭터 -> 8!
        // 각 순열마다 조건이 맞는지 체크 -> 모두 통과시 answer++;
        // 해시맵 : 각 캐릭터에 숫자 부여

        characterMap = new HashMap<Character, Integer>();
        characterMap.put('A', 0);
        characterMap.put('C', 1);
        characterMap.put('F', 2);
        characterMap.put('J', 3);
        characterMap.put('M', 4);
        characterMap.put('N', 5);
        characterMap.put('R', 6);
        characterMap.put('T', 7);

        permutation = new int[8];
        selected = new boolean[8];
        answer = 0;

        dfs(0, data);

        return answer;
    }

    static void dfs(int position, String[] data) {
        if(position == 8) {
            char compareOperation;
            int firstCharacter, secondCharacter, compareResult;

            for(int i = 0; i < data.length; i++) {
                firstCharacter = permutation[characterMap.get(data[i].charAt(0))];
                secondCharacter = permutation[characterMap.get(data[i].charAt(2))];

                compareOperation = data[i].charAt(3);
                compareResult = data[i].charAt(4)-'0';

                if(compareOperation == '>') {
                    if(Math.abs(firstCharacter-secondCharacter) - 1 <= compareResult) {
                        return;
                    }
                }
                else if(compareOperation == '<') {
                    if(Math.abs(firstCharacter-secondCharacter) - 1 >= compareResult) {
                        return;
                    }
                }
                else { // compareOperation == '='
                    if(Math.abs(firstCharacter-secondCharacter) - 1 != compareResult) {
                        return;
                    }
                }
            }

            answer++;
            return;
        }

        // position 위치의 캐릭터가 설 수 있는 모든 i
        for(int i = 0; i < 8; i++) {
            if(!selected[i]) {
                selected[i] = true;
                permutation[position] = i;
                dfs(position+1, data);
                selected[i] = false;
            }
        }
    }
}
