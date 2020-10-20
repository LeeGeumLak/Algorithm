package Programmers;

import java.util.Arrays;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tempArray = new int[ commands[i][1] - (commands[i][0]-1) ];

            for(int j = 0; j < tempArray.length; j++) {
                tempArray[j] = array[ j + (commands[i][0]-1) ];
            }
            Arrays.sort(tempArray);
            answer[i] = tempArray[ commands[i][2] - 1 ];
        }

        return answer;
    }
}
