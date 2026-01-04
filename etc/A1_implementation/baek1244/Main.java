package A1_implementation.baek1244;

import java.util.Scanner;

/**
 * 1244번 - 스위치 켜고 끄기
 * https://www.acmicpc.net/problem/1244
 * - ms() 에서 나누기 조건 실수 (인덱스)
 * - fs() 에서 String과 int 비교하는 실수 + for문으로 처리하면서 index 꼬임
 * - fs() 에서 중심을 토글하지 않는 실수
 * - n % 2 를 이용해서 숫자 토글할 수 있었음
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] sw = sc.nextLine().split(" ");

        int st = Integer.parseInt(sc.nextLine());

        for (int i=0 ; i<st ; i++) {
            String[] a = sc.nextLine().split(" ");
            who(sw, a);
        }

        for (int i = 0; i < sw.length; i++) {
            System.out.print(sw[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void who(String[] sw, String[] a) {
        if (Integer.parseInt(a[0]) == 1) {
            ms(sw, Integer.parseInt(a[1]));
        }else {
            fs(sw, Integer.parseInt(a[1]));
        }
    }

    public static void ms(String[] sw, int n) {
        for (int i=0 ; i<sw.length ; i++) {
            if ((i+1)%n == 0) {
                if (Integer.parseInt(sw[i]) == 1) {
                    sw[i] = "0";
                }else {
                    sw[i] = "1";
                }
            }
        }
    }

    public static void fs(String[] sw, int n) {
        int c = n-1;
        int l = c;
        int r = c;

        while (l >= 0 && r < sw.length && sw[l].equals(sw[r])) {
            if (sw[l].equals("0")) {
                sw[l] = "1";
            } else {
                sw[l] = "0";
            }

            if (l != r) {
                if (sw[r].equals("0")) {
                    sw[r] = "1";
                } else {
                    sw[r] = "0";
                }
            }

            l--;
            r++;
        }
    }
}
