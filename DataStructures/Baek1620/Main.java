package Baek1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * 백준 1620번 - 나는야 포켓몬 마스터 이다솜
 * https://www.acmicpc.net/problem/1620
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        System.out.print("포켓몬 개수 : " + input[0] + "문제 개수 : " + input[1]);
        int monLength = Integer.parseInt(input[0]);
        int questionLength = Integer.parseInt(input[1]);

        Map<String, Integer> strList = new HashMap<>();
        Map<Integer, String> intList = new HashMap<>();
        for (int i=0 ; i <monLength ; i++) {
            System.out.print("포켓몬 : ");
            String mon = sc.nextLine();
            strList.put(mon, i+1);
            intList.put(i+1, mon);
        }

        System.out.println("포켓몬 도감 : " + intList);

        for (int i = 0 ; i < questionLength ; i++) {
            System.out.print("포켓몬 검색 : ");
            String searchMon = sc.nextLine();
            if (isNum(searchMon)) {
                // 숫자
                String mon = intList.get(Integer.parseInt(searchMon));
                System.out.println("검색한 포켓몬 이름은 " + mon);
            } else {
                // 문자
                int mon = strList.get(searchMon);
                System.out.println("검색한 포켓몬 번호는 " + mon);
            }
        }
    }
    // 문자열인지 숫자인지 판별
    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
