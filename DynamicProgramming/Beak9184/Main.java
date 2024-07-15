package DynamicProgramming.Beak9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.2]
 * 백준 9184번 - 신나는 함수 실행
 * https://www.acmicpc.net/problem/9184
 * 
 * <문제 설명>
 * - 문제에서 주어진 식을 단순한 재귀함수로 구현하기는 쉽다.
 * - 하지만 입력한 숫자가 커질 경우 시간이 오래걸리는 단점을 가지고 있다.
 * - 그래서 동적 프로그래밍을 통해 해당 식을 계산하는데 걸리는 시간을 단축시키는 문제
 * 
 * <동적 계획법>
 * - 재귀적으로 함수가 계속 실행될 때 소요 시간을 줄여주기 위해 새로운 문제 값을 저장하고
 *   해당 문자값이 저장되어있으면 다시 계산해서 그 값을 얻어내는게 아니라
 *   미리 저장해두었던 값을 사용해 재귀적으로 함수를 실행시켜 시간을 단축하는 방법
 * - 동적 계획법은 대체로 재귀 + 메모제이션(Memoization)
 * 
 * <메모제이션>
 * - 컴퓨터 프로그램이 동일한 계산을 반복적으로 해야할 때,
 *   이전에 계산한 값을 메모리에 저장하여 중복적인 계산을 제거해 실행속도를 높이는 기법
 * https://velog.io/@wlwl99/%EB%A9%94%EB%AA%A8%EC%9D%B4%EC%A0%9C%EC%9D%B4%EC%85%98-Memoization
 * 
 * <문제 풀이>
 * - 입력값이 a,b,c 3개라서 3차원 배열을 생성해 재귀 함수 w로 계산된 값을 저장해 둠
 * - 재귀 함수 w에서 계산을 할 때마다 3차원 배열에 해당 값을 저장
 * - 재귀 함수 w에서 이미 계산된 값을 호출하면 새로 계산하는 것이 아닌 이미 계산되어 저장된 값을 반환
 * - 메모제이션 기법을 통해 중복적인 계산을 최소화하여 실행속도를 높임
 */
public class Main {
    // 재귀 함수 w에서 이미 계산된 값을 저장해둘 배열
    // 재귀 함수에서 a,b,c의 값이 20을 넘으면 20을 리턴하기 때문에 크기는 21
    private static int[][][] memo = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while (!(line = br.readLine()).equals("-1 -1 -1")) {
            String[] input = line.split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));
        }
        System.out.print(sb);
    }

    static int w(int a, int b, int c) {

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        
        // a,b,c 중 하나라도 20 이상이면 w(20, 20, 20)을 호출하기 때문에 memo[20][20][20]에 저장하고 반환
        if(a > 20 || b > 20 || c > 20) {
            return memo[20][20][20] = w(20, 20, 20);
        }

        // 이미 계산되어 저장되어 있는 경우에는 해당 값을 바로 반환
        if (memo[a][b][c] != 0) {
            return memo[a][b][c];
        }
            
        if(a < b && b < c) {
            memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        
        return memo[a][b][c];
    }
}
