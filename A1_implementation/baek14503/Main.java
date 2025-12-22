package A1_implementation.baek14503;

import java.util.Scanner;

/**
 * 14503번 - 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 * - 문제점 : 현업에서 하던 단위별로 기능별로 메서드를 쪼개던 습관이 과하게 나타남
 * - 괜히 쪼개지말고, 한 번에 해결 가능하게 고민할 것
 */
public class Main {
    // 방향: 0 북, 1 동, 2 남, 3 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 세로
        int M = sc.nextInt(); // 가로

        int r = sc.nextInt(); // 행
        int c = sc.nextInt(); // 열
        int d = sc.nextInt(); // 방향

        int[][] room = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = sc.nextInt();
            }
        }
        
        int cleaned = 0;

        while (true) {
            // 현재 칸 청소
            if (room[r][c] == 0) {
                room[r][c] = 2; // 청소 완료 표시
                cleaned++;
            }

            boolean moved = false;

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 회전 (0(북)->3(서) / 1(동)->0(북) / 2(남)-> 1(동) / 3(서)->2(남))
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (room[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                }
            }

            if (moved) continue;

            // 4방향 모두 청소 or 벽 → 후진
            int backDir = (d + 2) % 4; // 후진 계산
            int br = r + dr[backDir];
            int bc = c + dc[backDir];

            if (room[br][bc] == 1) {
                break; // 뒤가 벽 → 종료
            } else {
                r = br;
                c = bc;
            }
        }

        System.out.println(cleaned);
    }
}
