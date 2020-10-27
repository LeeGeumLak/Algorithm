package Programmers;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {
    // n 이하의 소수 개수 구하는 메서드
    /*public int calculateMinority(int n) {
        int answer = 0;
        boolean[] sosu =new boolean [n+1];

        for(int i=2; i<=n ; i++) sosu[i]=true;
        //2~n번째수를 true로 초기화

        // 제곱근 구하기
        int root=(int)Math.sqrt(n);

        for(int i=2; i<=root; i++) {
            //2~루트n까지 검사
            if(sosu[i]==true){
                //i번째의 수가 소수일 때
                for(int j=i; i*j<=n; j++)
                    //그 배수들을 다 false로 초기화(배수는 소수가 아니기 때문)
                    sosu[i*j]=false;
            }
        }

        for(int i =2; i<=n; i++) {
            if(sosu[i]==true)
                //소수의 개수 세기
                answer++;
        }

        return answer;
    }*/

    static int answer = 0;
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        // 한자리 숫자가 적힌 종이 조각이 흩어짐, 이 조각들을 붙여 몇개의 소수를 만들지
        // 입력 : 각 조각에 적힌 숫자 문자열 numbers
        // 출력 : 만들 수 있는 소수의 개수
        // 단, 1 <= numbers.length() <= 7 , 0 <= numbers[i] <= 9

        // 문자열을 toCharArray 메소드를 사용하여 char 배열로 만듦
        // 이 배열에 대해서 마찬가지로 output도 char 타입의 배열로 정의
        // 특정 output을 만들었다면, 이제 이것을 이용하여 이 배열 안에 수가 소수인지 확인
        // 단, 맨 첫 글자가 0으로 시작하면 그것은 자연수가 아니기때문에 false를 return 하고,
        //     배열 안에 수가 1 이하면 소수가 아니기때문에 false를 return

        // 특정 n에 대하여 i = 2부터 i <= sqrt(n)까지 n을 나눠보면서 나머지가 0이 있으면 false, 없으면 true를 return

        // 소수 알고리즘을 판단하는 함수에서 true 값이 반환되었다면, answer를 1 증가시키면서
        // 모든 경우의 의 수를 탐색하면 끝
        // 단, 같은 값을 탐색하는 경우도 존재하기때문에 소수를 발견하였으면 set에 넣어두고,
        // 새로운 수에 대해서 검사할때 마다 contains 메소드를 사용하여 중복 체크

        char[] arr = numbers.toCharArray();
        boolean[] select = new boolean[numbers.length()];
        char[] output = new char[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            permutation(arr, select, output, 0, numbers.length(), i);
        }

        return answer;
    }

    // 순열
    public static void permutation(char[] arr, boolean[] select, char[] output, int num, int size, int r) {
        if (num == r) {
            if (isPrime(output, r)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            if (select[i]) {
                continue;
            }
            select[i] = true;
            output[num] = arr[i];
            permutation(arr, select, output, num + 1, size, r);
            select[i] = false;
        }
    }

    public static boolean isPrime(char[] arr, int size) {
        if (arr[0] == '0') {
            return false;
        }

        String str = "";
        for (int i = 0; i < size; i++) {
            str += arr[i];
        }

        int temp = Integer.parseInt(str);

        if (temp <= 1 || set.contains(temp)) {
            return false;
        }

        for (int i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                return false;
            }
        }

        set.add(temp);
        return true;
    }
}
