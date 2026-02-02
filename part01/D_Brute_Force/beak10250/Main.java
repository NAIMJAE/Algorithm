package part01.D_Brute_Force.beak10250;

import java.util.Scanner;

/**
 * 백준 10250번 - ACM 호텔
 * https://www.acmicpc.net/problem/10250
 * - N이 H의 배수가 되는 경우를 생각하지 못했음
 * - N이 H의 배수가 되는 경우 N % H를 했을 때, 0이나와서 꼭대기층에 배정이 안됨
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i=0 ; i<T ; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            
            int x = ((N - 1) / H) + 1;
            int y = ((N - 1) % H) + 1;
            System.out.printf("%d%02d\n", y, x);
        }
    }
}
