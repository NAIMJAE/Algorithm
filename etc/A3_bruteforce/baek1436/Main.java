package A3_bruteforce.baek1436;

import java.util.Scanner;

/**
 * 1436번 - 영화감독 숌
 * https://www.acmicpc.net/problem/1436
 * 첫 시도 메모리 초과 (s.substring(i, i+3)에서 메모리 부하 같음)
 * .contains()를 이용해서 메모리를 줄였음
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int s = 666;
        int c = 0;
        while (c < n) {
            if (String.valueOf(s).contains("666")) {
                c++;
                if (c == n) break;
            }
            s++;
        }
        System.out.println(s);
    }
}
