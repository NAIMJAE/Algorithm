package DynamicProgramming.Beak1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.6]
 * 백준 1149 - RGB거리
 * https://www.acmicpc.net/problem/1149
 * 
 * <접근 방식>
 * - for문에서 현재 주기 + 다음 주기 의 값이 최소가 되는 경우를 찾아 더하는 방법으로 구현
 * - 주어진 예제코드는 모두 통과했지만 생각하지 못한 변수가 있었을 것으로 예상
 * - 예를 들자면 2번 이상 3개의 색상이 모두 같은 비용이면 결과가 이상했을 것 같음
 * 
 * <풀이 방법>
 * - 2차원 배열에 [집의 개수][색상별 가격] 를 저장
 * - 최소 비용을 계산하는 2차원 배열을 하나 더 만듦
 * - for문에서 현재 주기의 하나 전에서 더 작은 비용을 현재 주기에 더함
 * - 이때, 색상이 겹치는 것을 방지하기 위해 색상별로 따로 진행
 * - Bottom-up 방법을 이용해 작은 문제부터 큰 문제로 확장하는 방법
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];

        // [i][0] : R / [i][1] : G / [i][2] : B
        for (int i=0 ; i<N ; i++) {
            String[] input = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(input[0]);
            cost[i][1] = Integer.parseInt(input[1]);
            cost[i][2] = Integer.parseInt(input[2]);
        }

        int[][] min = new int[N][3];
        min[0][0] = cost[0][0];
        min[0][1] = cost[0][1];
        min[0][2] = cost[0][2];

        for (int i=1 ; i<N ; i++) {
            // red
            min[i][0] = cost[i][0] + Math.min(min[i-1][1], min[i-1][2]);
            // green
            min[i][1] = cost[i][1] + Math.min(min[i-1][0], min[i-1][2]);
            // blue
            min[i][2] = cost[i][2] + Math.min(min[i-1][0], min[i-1][1]);
        }

        int result = Math.min(min[N-1][0], Math.min(min[N-1][1], min[N-1][2]));
        System.out.println(result);
    }
}
