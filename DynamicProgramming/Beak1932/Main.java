package DynamicProgramming.Beak1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 백준 1932번 - 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 * 
 * <접근 방법>
 * - 꼭대기부터 아래로 가며 하나씩 더해 모든 경우의 수를 구해 가장 큰 수 찾기
 *   # 이 방법은 N이 커지면 경우의 수가 너무 많아지기에 포기
 * - 아래에서부터 꼭대기로 올라가며 하나씩 더해 가장 큰수 찾기
 *   # 이 방법은 경우의 수가 N개 밖에 없지만 더 큰수를 비교하는 과정에서 같은 수가 있을때 처리 방법에서 포기
 * - 꼭대기부터 아래로 가며 하나씩 더하지만 더 작은 수는 버리며 가장 큰 수 찾기 
 *   # 이 방법은 경우의 수도 N개이며 같은 수를 비교하는 과정도 처리 가능함
 * 
 * <풀이 방법>
 * - 입력한 수를 담아두는 2차원 배열과 더 큰 수를 더한 값을 저장할 2차원 배열을 각각 생성
 * - 입력한 수를 담은 2차원 배열에서 for문을 돌며 이 전의 값중 더 큰 값을 더해 다른 2차원 배열에 저장
 * - for문이 끝난 후 더한 값을 저장한 2차원 배열의 마지막 줄에서 가장 큰 수를 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][];

        // 입력받은 값으로 2차원 배열 만들기
        for (int i=0 ; i<N ; i++) {
            arr[i] = new int[i+1];
            String[] input = br.readLine().split(" ");
            for (int k=0 ; k<=i ; k++) {
                arr[i][k] = Integer.parseInt(input[k]);
            }
        }

        // 모든 경우의 수 합 찾기
        int[][] sum = new int[N][N];
        sum[0][0] = arr[0][0];
        for (int i=1 ; i<N ; i++) {
            for (int k=0 ; k<arr[i].length ; k++) {
                System.out.println("i : " + i + " | k : " + k);
                System.out.println(Arrays.toString(arr[i-1]));
                System.out.println(Arrays.toString(arr[i]));
                System.out.println(Arrays.toString(sum[i-1]));
                System.out.println(Arrays.toString(sum[i]));
                if (k==0) {
                    sum[i][k] = arr[i][k] + sum[i-1][k];
                }else if (i==k) {
                    sum[i][k] = arr[i][k] + sum[i-1][k-1];
                }else {
                    sum[i][k] = arr[i][k] + Math.max(sum[i-1][k], sum[i-1][k-1]);
                }
            }
        }
        System.out.println(Arrays.toString(sum[N-1]));

        // 가장 큰 경우 출력
        int max = sum[N - 1][0];
        for (int i = 1; i < sum[N - 1].length; i++) {
            if (sum[N - 1][i] > max) {
                max = sum[N - 1][i];
            }
        }
        System.out.println(max);
    }
}