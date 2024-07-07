package Baek1002;

import java.util.Scanner;

/*
 * 백준 1002번 - 터렛
 * https://www.acmicpc.net/problem/1002
 * 
 * 두 사람의 x, y 좌표와 목표물과의 거리 r을 입력받아 r이 존재하는 경우의 수 구하는 문제
 * <접근 방법>
 * - x, y 좌표와 r을 이용해 원을 그리고 두 원의 접점 개수 구하는 문제
 * - 두 사람의 x, y 좌표를 이용해 두 사람의 거리 구함
 * - 두 사람의 거리와 r1, r2 의 합과 차를 이용해 접점의 개수 구하기
 * <경우의 수>
 * 1. 두 원이 완전히 겹치는 경우 : 접점 무한대
 * 2. 두 원이 겹치면서 인접하는 경우 : 접점 1개
 * 3. 두 원이 겹치면서 인접하지 않는 경우 : 접점 0개
 * 4. 두 원이 겹치지 않으면서 인접하는 경우 : 접점 1개
 * 5. 두 원이 겹치지 않으면서 인접하지 않는 경우 : 접점 2개
 * 6. 두 원이 겹치지 않는 경우 : 접점 0개
 */
/*
<입력 예제>
3
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i=0 ; i < T ; i++) {
            System.out.print("테스트 케이스 입력");
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
    
            double distance = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
            int sum = r1 + r2;
		    int sub = Math.abs(r1 - r2);

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    System.out.println(-1);
                }else {
                    System.out.println(0);
                }
            }else {
                if (distance > sum || distance < sub) {
                    System.out.println(0);
                }else if (distance == sum || distance == sub) {
                    System.out.println(1);
                }else if (distance < sum) {
                    System.out.println(2);
                }
            }
        }
        sc.close();
    }
}
