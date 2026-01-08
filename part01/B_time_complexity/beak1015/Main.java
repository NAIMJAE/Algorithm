package part01.B_time_complexity.beak1015;

import java.util.Scanner;

/**
 * 백준 10158번 - 개미
 * https://www.acmicpc.net/problem/10158
 * - 문제에서 w와 h는 자연수이며 범위는 2 ≤ w,h ≤ 40,000이다. 그리고 개미의 초기 위치 p와 q도 자연수이며 범위는 각각 0 < p < w과 0 < q < h이다. 그리고 계산할 시간 t의 범위는 1 ≤ t ≤ 200,000,000이다. 
 * - 정답은 찾을 수 있지만, 문제에서 제시한 시간 제한을 충족 못하는 코드
 */
public class Main {
    static int dw = 1;
    static int dh = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] size = sc.nextLine().split(" ");
        String[] start = sc.nextLine().split(" ");
        int t = sc.nextInt();

        int w = Integer.parseInt(size[0]);
        int h = Integer.parseInt(size[1]);
        
        int p = Integer.parseInt(start[0]);
        int q = Integer.parseInt(start[1]);

        System.out.println("(" + p + ":" + q + ")");

        while (0 < t) {
            System.out.println("--");
            System.out.println("t : " + t);
            isWall(w, h, p, q);

            p = p + dw;
            q = q + dh;
            System.out.println("(" + p + ":" + q + ")");
            t--;
        }
        System.out.println(p + " " + q);
    }

    // 오위 : +1, +1 / 왼위 : -1, +1 / 왼아 : -1, -1 / 오아 : +1, -1
    // (4,1) -> (5,2) -> (6,3) -> (5,4) -> (4,3) -> (3,2) -> (2,1) -> (1,0) -> (0,1)

    // 벽에 도달하면 부호 변경
    public static void isWall(int w, int h, int p, int q) {
        System.out.println("w, h, p, q" + " | " + w + " " + h + " " + p + " " + q);
        if (w == p) { dw = dw * -1; }
        if (h == q) { dh = dh * -1; }
        if (p == 0) { dw = dw * -1; }
        if (q == 0) { dh = dh * -1; }
    }
}
