package part01.D_Brute_Force.beak2503;

import java.util.Scanner;

/**
 * 백준 2503번 - 숫자 야구
 * https://www.acmicpc.net/problem/2503
 * - 모든 경우의 수에서 일치하지 않는 경우를 제외하는 방법으로 해결
 * - 성공 후 calNum() 함수를 배열을 활용하는 방식으로 더 효율적이게 변경
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] num = new int[504];
        int count = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i==j || i==k || j==k) { continue; }
                    
                    num[count++] = i*100 + j*10 + k;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int ask = sc.nextInt();
            int S = sc.nextInt();
            int B = sc.nextInt();

            for (int j = 0; j < num.length; j++) {
                if (num[j] == 0) { continue; }

                boolean result = calNum(num[j], ask, S, B);

                if (!result) { num[j] = 0; }
            }
        }

        int ans = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) { continue; }
            ans++;
        }

        System.out.println(ans);
    }

    public static boolean calNum(int num, int ask, int S, int B) {
        int[] numIdx = {num / 100, (num % 100) / 10, num % 10};
        int[] askIdx = {ask / 100, (ask % 100) / 10, ask % 10};

        int sCount = 0;
        int bCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (numIdx[i] == askIdx[j]) {
                    if (i == j) sCount++; // 자리가 같으면 스트라이크
                    else bCount++;        // 자리는 다른데 숫자가 있으면 볼
                }
            }
        }

        return (sCount == S && bCount == B);
    }
}
