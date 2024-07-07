package Beak17615;

import java.util.Scanner;

/*
 * 백준 17615번 - 볼 모으기
 * https://www.acmicpc.net/problem/17615
 * 
 * <접근 방법>
 * - 공을 이동시키는 4가지 경우의 수를 각각 계산 한 후 최소값 구하기
 * - boolean을 통해서 공을 이동시키는 정확한 횟수 구할 수 있음
 * 
 * <입력 예제>
 * 9
 * RBBBRBRRR
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("볼 개수 : ");
        int N = sc.nextInt();
        sc.nextLine();

        System.out.print("볼 색상 : ");
        String ball = sc.nextLine();
        char[] ballArr = ball.toCharArray();
        int min = Integer.MAX_VALUE;

        // 빨간공을 왼쪽으로
        int count = 0;
        boolean sw = false;
        for (int i=0 ; i<N ; i++) {
            if (sw && ballArr[i] == 'R') {
                count++;
                continue;
            }
            if (ballArr[i] == 'B') {
                sw = true;
            }
        }
        min = Math.min(min, count);
        System.out.println("min : " + min + " | count : " + count);
                
        // 빨간공을 오른쪽으로
        count = 0;
        sw = false;
        for (int i=N-1 ; i>=0 ; i--) {
            if (sw && ballArr[i] == 'R') {
                count++;
                continue;
            }
            if (ballArr[i] == 'B') {
                sw = true;
            }
        }
        min = Math.min(min, count);
        System.out.println("min : " + min + " | count : " + count);

        // 파란공을 왼쪽으로
        count = 0;
        sw = false;
        for (int i=0 ; i<N ; i++) {
            if (sw && ballArr[i] == 'B') {
                count++;
                continue;
            }
            if (ballArr[i] == 'R') {
                sw = true;
            }
        }
        min = Math.min(min, count);
        System.out.println("min : " + min + " | count : " + count);
                
        // 파란공을 오른쪽으로
        count = 0;
        sw = false;
        for (int i=N-1 ; i>=0 ; i--) {
            if (sw && ballArr[i] == 'B') {
                count++;
                continue;
            }
            if (ballArr[i] == 'R') {
                sw = true;
            }
        }
        min = Math.min(min, count);
        System.out.println("min : " + min + " | count : " + count);

        System.out.println("최소 이동 : " + min);
    }
}
