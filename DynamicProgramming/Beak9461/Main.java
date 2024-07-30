package DynamicProgramming.Beak9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.4]
 * 백준 9461번 - 파도반 수열
 * https://www.acmicpc.net/problem/9461
 * 
 * <접근 방식>
 * - 문제에서 N의 범위가 (1 ≤ N ≤ 100)이기 때문에 for문을 통해 100까지 파도반 수열을 미리 계산
 * - 그러고 입력한 숫자에 알맞은 값을 result 배열에 저장해 두고 출력
 * - 근데 타입에러를 생각하지 못했음.. 
 * - N이 47이 되는 범위부터 int의 범위를 초과해서 오버플로우 발생
 * - 고로 long 타입을 써서 풀어야하는 문제였음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        long[] result = new long[N];

        for (int i=4 ; i<arr.length ; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }

        for (int i=0 ; i<N ; i++) {
            result[i] = arr[Integer.parseInt(br.readLine())];
        }

        for (int i=0 ; i<N ; i++) {
            System.out.println(result[i]);
        }
    }
}
