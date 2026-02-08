package part01.D_Brute_Force.beak14891;

import java.util.Scanner;

/**
 * 백준 14891번 - 톱니바퀴
 * https://www.acmicpc.net/problem/14891
 * - 초기 코드에서 처음 회전시키는 톱니(N)의 회전을 누락
 * - 회전 방향 전파 시 지그재그 반전이 루프마다 초기화되어 유지되지 않았음
 * - 회전 대상인 주변 바퀴 대신 기준 바퀴만 중복해서 리스트에 담았음 (for문에서 idx를 쓰지 않음)
 * - 왼쪽, 오른쪽으로 회전할 wheel의 index를 저장하는 방법 대신,
 *   directions 배열을 만들어 어느 방향으로 회전시킬지 저장하는 방법으로 선회
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0 - 12시 // 2 - 3시 // 4 - 6시 // 6 - 9시
        int[][] wheel = new int[4][8];

        for (int i = 0; i < 4; i++) {
            char[] str = sc.nextLine().toCharArray();
            for (int j = 0; j < str.length; j++) {
                wheel[i][j] = Integer.parseInt(String.valueOf(str[j]));
            }
        }

        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            
            compareWheel(wheel, N, D);
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int score = wheel[i][0];
            if (score > 0) {
                sum += (int) Math.pow(2, i);
            }
        }

        System.out.println(sum);
    }

    public static void compareWheel(int[][] wheel, int N, int D) {
        int[] directions = new int[4]; 
        int startIdx = N - 1; // 0~3으로 보정
        directions[startIdx] = D;

        // 왼쪽으로 전파
        for (int i = startIdx; i > 0; i--) {
            if (wheel[i][6] != wheel[i-1][2]) {
                directions[i-1] = -directions[i]; // 옆 바퀴의 반대 방향
            } else {
                break;
            }
        }

        // 오른쪽으로 전파
        for (int i = startIdx; i < 3; i++) {
            if (wheel[i][2] != wheel[i+1][6]) {
                directions[i+1] = -directions[i]; // 옆 바퀴의 반대 방향
            } else {
                break;
            }
        }

        // 회전
        for (int i = 0; i < 4; i++) {
            if (directions[i] != 0) {
                rotationWheel(wheel, i, directions[i]);
            }
        }
    }

    public static void rotationWheel(int[][] wheel, int idx, int D) {
        int[] tmp = new int[8];
        int[] select = wheel[idx];

        for (int i = 0; i < select.length; i++) {
            int C = i+D;
            if (C < 0) { C += 8; }
            if (C > 7) { C -= 8; }
            tmp[C] = select[i];
        }
        wheel[idx] = tmp;
    }
}
