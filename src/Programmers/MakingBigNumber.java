package Programmers;

public class MakingBigNumber {
    public String solution(String number, int k) {
        // 어떤 숫자에서 k개의 수를 제거했을 때의 가장 큰 수 구하기
        // 입력 : 문자열 number , 숫자 k
        // 출력 : k개의 수를 제거했을 때의 가장 큰 숫자를 문자열로 출력
        // 단, 10^0 <= number <= 10^8 - 1 , 1 <= k <= number.length()

        int idx = 0;
        char max;

        StringBuilder answer = new StringBuilder();

        if(number.charAt(0) == '0') return "0";

        for(int i = 0; i < number.length() - k; i++) {
            max = '0';

            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j); idx = j + 1;
                }
            }

            answer.append(max);
        }

        return answer.toString();


        // cool answer
        /*
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
         */
    }
}
