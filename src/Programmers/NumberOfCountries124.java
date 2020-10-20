package Programmers;

public class NumberOfCountries124 {
    public String solution(int n) {
        String answer = "";

        // 3으로 나누었을 때, 나머지가 0, 1, 2 (단, 나누어 떨어지면 -1)
        String[] numbers = {"4", "1", "2"};

        while(n > 0) {
            int tempNum = n % 3;
            n = n / 3;

            if(tempNum == 0) {
                n--;
            }

            answer = numbers[tempNum] + answer;
        }

        return answer;
    }
}
