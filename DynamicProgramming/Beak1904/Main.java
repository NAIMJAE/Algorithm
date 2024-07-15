package DynamicProgramming.Beak1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.3]
 * 백준 1904번 - 01타일
 * https://www.acmicpc.net/problem/1904
 * 
 * <접근 방법>
 * - N = (N-2) + (N-1) / 피보나치 수열의 규칙으로 증가
 * - 배열에 N번째 2진 수열의 개수를 저장하는 방법
 * - 그런데 N번째 2진 수열이 아니라 2진 수열을 15746으로 나눈 나머지를 저장하면 메모리를 절약할 수 있음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        } else if (N == 2) {
            System.out.println(2);
            return;
        }

        int[] arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= N; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 15746;
        }

        System.out.println(arr[N]);
    }
}
