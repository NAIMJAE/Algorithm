package Test;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        
        double total_reword = 1000000; // 총 리워드 COIN
        double current_trading_volume = 2411; // 현재 거래량 USDT
        double current_reword = 4.3649; // 현재 리워드 COIN

        double target_amount = 3.5; // 목표 금액 USDT

        double exchange_rate = 0.8327; // 1코인의 USDT 가격

        double transaction_fee = 0.0015; // 거래 수수료 USDT

        double increase = 0; // 거래량 증가치 USDT

        double total_trading_volume = current_trading_volume / (current_reword / total_reword);
        System.out.println("total_trading_volume : " + total_trading_volume);

        while (ceilFee(current_trading_volume, increase, current_reword, transaction_fee, exchange_rate) < target_amount) {
            increase += 100;
            current_reword = ((current_trading_volume + increase) / (total_trading_volume + increase)) * total_reword;
            
            System.out.println("추가 거래량 USDT : " + increase);
            System.out.println("최종 거래량 USDT : " + (current_trading_volume + increase));
            System.out.println("예측 보상 COIN : " + current_reword);
            System.out.println("예측 보상 USDT : " + current_reword * exchange_rate);
            System.out.println("------------------------------------------------------------");
        }
    }

    public static double ceilFee(double current_trading_volume, double increase, double current_reword, double transaction_fee, double exchange_rate) {
        double current_fee = current_trading_volume * transaction_fee; // 기존 수수료
        double increase_fee = increase * transaction_fee; // 추가 수수료

        double estimated_USDT = current_reword * exchange_rate; // 보상 리워드 USDT
        
        System.out.println("총 수수료 USDT : " + (current_fee + increase_fee));
        System.out.println("수수료 제외 보상 USDT : " + (estimated_USDT - current_fee - increase_fee));
        System.out.println("수수료 제외 보상 KRW : " + (estimated_USDT - current_fee - increase_fee) * 1437.75);

        return estimated_USDT - current_fee - increase_fee;
    }
}
