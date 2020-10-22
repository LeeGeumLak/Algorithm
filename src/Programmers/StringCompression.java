package Programmers;

import java.util.ArrayList;

public class StringCompression {
    public int solution(String s) {
        // aabbaccc -> 2a2ba3c
        // ababcdcdababcdcd -> 2ab2cd2ab2cd
        //                  -> 2ababcdcd
        // abcabcdede -> abcabc2de
        //            -> 2abcdede
        // 입력 : 문자열
        // 출력 : 압축시, 가장 짧은 길이

        int answer = s.length();

        int maxDivider = s.length() / 2;

        for(int divider = 1; divider <= maxDivider; divider++) {
            int currentLength = 0;
            int start = 0, end = divider;

            ArrayList<String> pieces = new ArrayList<>();

            while(start < s.length()) {
                if(s.length() < end) {
                    end = s.length();
                }

                pieces.add(s.substring(start, end));
                start += divider;
                end += divider;
            }

            int duplicate = 1;
            String before = "";
            String next = "";

            for(int i = 0; i < pieces.size(); i++) {
                before = pieces.get(i);

                if(i == pieces.size() - 1) {
                    next = "";
                }
                else {
                    next = pieces.get(i + 1);
                }

                if(before.equals(next)) {
                    duplicate++;
                }
                else {
                    String temp = "";

                    if(duplicate == 1) {
                        temp = before;
                    }
                    else {
                        temp = String.valueOf(duplicate) + before;
                        duplicate = 1;
                    }
                    currentLength += temp.length();
                }
            }

            if(answer > currentLength) {
                answer = currentLength;
            }
        }
        return answer;
    }
}
