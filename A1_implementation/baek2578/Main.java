package A1_implementation.baek2578;

import java.util.Scanner;

/**
 * 2578번 - 빙고
 * https://www.acmicpc.net/problem/2578
 * 효과적인 방법? 성능? 생각보다는 어떻게 풀어야할지에 집중
 */
public class Main {
    static int[][] bingo = new int[5][5];

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        for (int i=0 ; i<5 ; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j=0 ; j<5 ; j++) {
                bingo[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][] mark = new int[5][5];
        for (int i=0 ; i<5 ; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j=0 ; j<5 ; j++) {
                mark[i][j] = Integer.parseInt(s[j]);
            }
        }

        int n = 0;

        outer:
        for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                n++;
                int c = mark[i][j];
                call(c);
                if (check()) {
                    break outer;
                }
            }
        }
        System.out.println(n);
    }

    public static void call(int c) {
        for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                int b = bingo[i][j];
                if (b == c) {
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static boolean check() {
        int count = 0;
        // 가로 / 세로
        for (int i=0 ; i<5 ; i++) {
            int w = 0;
            int h = 0;
            for (int j=0 ; j<5 ; j++) {
                if (bingo[i][j] == 0) { w++; }
                if (bingo[j][i] == 0) { h++; }
            }
            if (w == 5) { count++; }
            if (h == 5) { count++; }
        }

        // 대각선
        int c1 = 0;
        int c2 = 0;
        for (int i=0 ; i<5 ; i++) {
            if (bingo[i][i] == 0) {c1++;}
            if (bingo[i][4-i] == 0) {c2++;}
        }
        if (c1 == 5) { count++; }
        if (c2 == 5) { count++; }

        if (count >= 3) {
            return true;
        }else {
            return false;
        }
    }
}
