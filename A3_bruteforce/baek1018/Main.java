package A3_bruteforce.baek1018;

import java.util.Scanner;

/**
 * 1018번 – 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 * - 체스판 패턴을 “이전 칸과 같은지 여부”로만 비교하려고 해서 문제 의도와 전혀 다른 기준으로 칸을 세고 있었음
 * 
 * - 8×8 시작 위치를 0 ≤ i ≤ N-8, 0 ≤ j ≤ M-8 전부 순회해야 한다는 점과, 
 * - 왼쪽 위가 W인 경우 / B인 경우 두 패턴을 각각 비교해서 최소 칠해야 할 칸 수를 구해야 한다는 점을 놓쳤다.
 * 
 * - “체스판 규칙”은 (행+열)이 짝수인 칸과 홀수인 칸의 색이 번갈아야 한다는 것이고, 
 * - 각 8×8 구간마다 이 규칙을 기준으로 W 시작, B 시작 두 경우의 repaint 횟수를 계산한 뒤 그중 최솟값을 전체 최소값과 갱신해야 한다.
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        char[][] board = new char[n][m];
        for (int i=0 ; i<n ; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = 64; // 최대 64칸

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int repaint = countRepaint(board, i, j);
                answer = Math.min(answer, repaint);
            }
        }

        System.out.println(answer);
    }

    static int countRepaint(char[][] board, int x, int y) {
        int cntW = 0; // (x,y)가 'W'로 시작하는 체스판으로 맞출 때 repaint 수
        int cntB = 0; // (x,y)가 'B'로 시작하는 체스판으로 맞출 때 repaint 수

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char cur = board[x + i][y + j];

                // (i + j)가 짝수면 시작 색, 홀수면 반대 색
                if ((i + j) % 2 == 0) { // 짝수 칸
                    if (cur != 'W') cntW++; // W 시작인데 지금 W가 아니면 다시 칠해야 함
                    if (cur != 'B') cntB++; // B 시작인데 지금 B가 아니면 다시 칠해야 함
                } else { // 홀수 칸
                    if (cur != 'B') cntW++; // W 시작이면 홀수 칸은 B여야 함
                    if (cur != 'W') cntB++; // B 시작이면 홀수 칸은 W여야 함
                }
            }
        }

        return Math.min(cntW, cntB);
    }
}
