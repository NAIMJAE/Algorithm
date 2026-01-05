package part01.A_string.beak13223;

import java.util.Scanner;

/**
 * 백준 13223번 - 소금 폭탄
 * https://www.acmicpc.net/problem/13223
 * - if (needAmount <= 0) 때문에 실패
 * - 두 시간의 차가 0이되는 경우 (24시간 차이)를 고려하지 않았음
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String now = sc.nextLine();
        String trg = sc.nextLine();
        String[] nowArr = now.split(":");
        String[] trgArr = trg.split(":");

        int nowAmount = Integer.parseInt(nowArr[0]) * 3600 + Integer.parseInt(nowArr[1]) * 60 + Integer.parseInt(nowArr[2]);
        int trgAmount = Integer.parseInt(trgArr[0]) * 3600 + Integer.parseInt(trgArr[1]) * 60 + Integer.parseInt(trgArr[2]);

        int needAmount = trgAmount - nowAmount;
        if (needAmount <= 0) { needAmount += 24 * 3600; }

        int hours = needAmount / 3600;
        int minutes = needAmount % 3600 / 60;
        int seconds = needAmount % 3600 % 60;

        System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
    }
}
