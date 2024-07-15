package DynamicProgramming.Beak24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.1]
 * 백준 24416번 - 알고리즘 수업 피보나치 수 1
 * https://www.acmicpc.net/problem/24416
 * 
 * <문제 설명>
 * - 피보나치 수열을 만들기 위해 재귀호출과 동적프로그래밍 두 가지 방법 중 어떤 방법이 더 효율적인가를 알아보는 문제
 * - 피보나치 수열 (첫째 및 둘째 항이 1이며 그 뒤의 모든 항은 바로 앞 두 항의 합인 수열)
 * 
 * <문제 풀이>
 * - 재귀호출 의사 코드는 시간복잡도가 O(2^n)
 * - 동적 프로그래밍 의사 코드의 시간복잡도는 O(n)
 */
public class Main {

    static int fib1Cnt;
    static int fib2Cnt;

    static int[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        f = new int[n];

        br.close();

        fib1Cnt = 0;
        fib2Cnt = 0;

        fib(n);
        fibonacci(n);

        System.out.println(fib1Cnt + " " + fib2Cnt);
    }

    // 피보나치 수 재귀 호출 코드
    /*
     * n = 5
     * fib(5) -> fib(4) + fib(3) -> 3 + 2
     * fib(4) -> fib(3) + fib(2) -> 2 + 1
     * fib(3) -> fib(2) + fib(1) -> 1 + 1
     * 
     * fib(3) -> fib(2) + fib(1) -> 1 + 1
     */
    static int fib(int n) {
        if (n ==1 || n == 2) {
            fib1Cnt++;
            return 1;
        }else {
            return (fib(n-1) + fib(n-2));
        }
    }

    // 피보나치 수 동적 프로그래밍 코드
    /*
     * n = 5
     * fibonacci(5)
     * f[2] = f[1] + f[0] -> 1 + 1
     * f[3] = f[2] + f[1] -> 2 + 1
     * f[4] = f[3] + f[2] -> 3 + 2
     */
    static int fibonacci(int n) {
        f[0] = 1;
        f[1] = 1;

        for (int i=2 ; i<n ; i++) {
            fib2Cnt++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n-1];
    }
}
