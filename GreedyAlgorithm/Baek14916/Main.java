package Baek14916;

import java.util.Scanner;

/*
 * 백준 14916번 - 거스름돈
 * https://www.acmicpc.net/problem/14916
 * 
 * <접근 방법>
 * - 거스름돈이 5의 배수가 될때까지 -2 하며 coin 개수 +1
 * - 1과 3 처럼 거스름돈을 줄 수 없는 예외 경우 처리
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("거스름돈 입력 : ");
        int change = sc.nextInt();

        int coin = 0;

        // 5원 -> 5원 1개
        // 6원 -> 2원 3개 ㅇ
        // 7원 -> 5원 1개 / 2원 1개
        // 8원 -> 2원 4개 ㅇ
        // 9원 -> 5원 1개 / 2원 2개
        // 10원 -> 5원 2개
        // 11원 -> 5원 1개 / 2원 3개 ㅇ
        // 12원 -> 5원 2개 / 2원 1개
        // 13원 -> 5원 1개 / 2원 4개 ㅇ
        // 14원 -> 5원 2개 / 2원 2개
        // 15원 -> 5원 3개
        // 16원 -> 5원 2개 / 2원 3개 ㅇ
        // 17원 -> 5원 3개 / 2원 1개
        // 18원 -> 5원 2개 / 2원 4개 ㅇ
        // 19원 -> 5원 3개 / 2원 2개
        // 20원 -> 5원 4개
        // 21원 -> 5원 3개 / 2원 3개

        // 5의 배수인가?
        // - 2 반복?
        if (change == 1 || change == 3) {
            coin = -1;
        } else {
            while (change > 0) {
                if ((change % 5) == 0) {
                    coin += change / 5;
                    break;
                } else {
                    coin += 1;
                    change -= 2;
                }
                if (change < 0) {
                    break;
                }
            }
        }
        System.out.println("거스름돈 개수 : " + coin);
    }
}
