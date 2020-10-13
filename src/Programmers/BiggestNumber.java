package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    public String solution(int[] numbers) {
        String answer = new String();

        String strNumbers[] = new String[numbers.length];

        for(int i = 0; i < strNumbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(strNumbers[0].startsWith("0")) {
            answer += "0";
        } else {
            for(int j=0; j<strNumbers.length; j++) {
                answer += strNumbers[j];
            }
        }

        return answer;
    }
}
