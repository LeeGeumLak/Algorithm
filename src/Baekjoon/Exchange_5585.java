package Baekjoon;

        import java.util.Scanner;

public class Exchange_5585 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int price = 0;
        price = inputParameter.nextInt();

        int exchange = 1000 - price;

        System.out.println( calExchangeCoinNum(exchange) );
    }

    public static int calExchangeCoinNum(int exchange) {
        int coinNum = 0;

        int[] coinType = {500, 100, 50, 10, 10, 5, 1};

        for(int i = 0; i < coinType.length; i++) {
            if(exchange >= coinType[i]) {
                coinNum += exchange / coinType[i];
                exchange = exchange % coinType[i];
            }
        }

        return  coinNum;
    }
}
