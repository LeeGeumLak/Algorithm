package Programmers;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        // 구조대 : 119
        // 박준영 : 97 674 223
        // 지영석 : 11 9552 4421
        // 구조대의 전화번호는 영석이 것의 접두사
        // 입력 : 전체 전화번호가 적힌 문자열 배열 phone_book
        // 출력 : 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false, 아니면 true
        // 단, 1 <= phone_book.length <= 1000000 , 1 <= phone_book[i].length() <= 20

        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book.length; j++) {
                if( (i != j) && (phone_book[j].indexOf(phone_book[i]) == 0) ) {
                    return false;
                }
            }
        }

        return true;
    }
}
