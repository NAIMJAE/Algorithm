package part01.D_Brute_Force.beak2840;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2840번 - 행운의 바퀴
 * https://www.acmicpc.net/problem/2840
 * - 화살표가 가르키는 인덱스가 음수가 나오는 케이스를 완벽하게 처리하지 못함
 * - 시계, 반시계 방향에 따라 인덱스가 움직이는 방향을 혼동
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');

        int currentPos = 0; // 현재 화살표가 가르키는 인덱스

        for (int i = 0; i < K; i++) {
            int S = sc.nextInt(); // 이동 칸수
            char T = sc.next().charAt(0); // 멈춘 글자

            // 인덱스 이동 | 음수가 나오면 반대편으로 돌아가게 N을 더하고 다시 % N 처리
            currentPos = (currentPos - (S % N) + N) % N;
          
            // 이미 글자가 있는데, 다른 글자를 넣는 경우
            if (wheel[currentPos] != '?' && wheel[currentPos] != T) {
                System.out.println("!");
                return;
            }

            // 같은 글자가 바퀴의 다른 칸에 이미 존재하는 경우
            for (int j = 0; j < N; j++) {
                if (wheel[j] == T && j != currentPos) {
                    System.out.println("!");
                    return;
                }
            }

            wheel[currentPos] = T;
        }

        // 마지막 위치는 시작점
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(wheel[(currentPos + i) % N]);
        }
        System.out.println(sb.toString());
    }
}
