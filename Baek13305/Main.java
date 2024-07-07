package Baek13305;

import java.util.Scanner;
/*
 * 백준 13305번 - 거스름돈
 * https://www.acmicpc.net/problem/13305
 * 
 * - nextInt()로 입력을 받았을 경우 58점 받음
 * - 숫자가 큰 경우 int로 계산에 한계가 있기때문
 * - nextLong()로 타입 변경해서 만점
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("도시 개수 : ");
        int city = sc.nextInt();
        long[] load = new long[city-1];
        long[] oil = new long[city];

        for (int i=0 ; i<city-1 ; i++) {
            System.out.print("도로의 길이 : ");
            load[i] = sc.nextLong();
        }
        for (int i=0 ; i<city ; i++) {
            System.out.print("기름 가격 : ");
            oil[i] = sc.nextLong();
        }

        long cost = oil[0];
        long sum = 0;
        for (int i=0 ; i<city-1 ; i++) {
            if (oil[i] < cost) {
                cost = oil[i];
            }
            sum += cost * load[i];
        }

        System.out.println("최소 비용 : " + sum);
    }
}
