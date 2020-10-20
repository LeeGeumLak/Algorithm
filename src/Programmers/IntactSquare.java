package Programmers;

public class IntactSquare {
    public long solution(int w, int h) {
        long answer = 1;

        long totalSquare = (long)w * (long)h;

        long min, max;
        if(w < h) {
            min = (long)w;
            max = (long)h;
        }
        else {
            min = (long)h;
            max = (long)w;
        }

        long value = 1;
        while(value > 0) {
            value = max % min;
            max = min;
            min = value;
        }

        long damagedSquare = (long)w + (long)h - max; // ( (w / max) + (h / max) - 1 ) * max

        answer = totalSquare - damagedSquare;
        return answer;
    }
}
