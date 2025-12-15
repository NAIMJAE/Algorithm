package A3_bruteforce.baek1138;

import java.util.Scanner;

/**
 * 1138번 - 한 줄로 서기
 * https://www.acmicpc.net/problem/1138
 * - 순서대로 반복을 돌면서 왼쪽에 나보다 키가 큰 사람이 몇명 있는지를 매번 검증해야하는 감은 잡음
 * - 못풀겠어서 찾아보다가 잘못된 풀이를 봐서 시간 날림 -> 재도전 해야함
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] leftCount = new int[N + 1];   // leftCount[i] = i번 사람 왼쪽에 있어야 할 키 큰 사람 수

        for (int i = 1; i <= N; i++) {
            leftCount[i] = sc.nextInt();
        }

        int[] line = new int[N];           // 줄에 선 사람 번호 (0이면 아직 빈 자리)

//



//

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(line[i]);
            if (i < N - 1) sb.append(' ');
        }
        System.out.println(sb);
    }
}
