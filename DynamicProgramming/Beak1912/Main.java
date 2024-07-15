package DynamicProgramming.Beak1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.5]
 * 백준 1912 - 파도반 수열
 * https://www.acmicpc.net/problem/1912
 * 
 * <접근 방식>
 * - 연속된 두 수를 더하는 것이 아니라 연속되기만 하면 몇 개의 수를 더하든 상관 없음
 * - 고로 메모제이션을 통해 풀어야 함 (2차원 배열 or 어떠한 규칙)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        arr[0] = Integer.parseInt(input[0]);
        int result = 0;
        for (int i=1 ; i<N ; i++) {
            arr[i] = Integer.parseInt(input[i]) + Integer.parseInt(input[i-1]);
            if (i == 1) {
                result = arr[0];
            }
            if (arr[i] > arr[i-1]) {
                result = arr[i];
            }
        }
        System.out.println(result);
    }
}
