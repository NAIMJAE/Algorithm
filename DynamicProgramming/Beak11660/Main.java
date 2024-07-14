package DynamicProgramming.Beak11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 11660번 - 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 * 
 * <접근 방법>
 * - 2차원 배열을 [N+1][N+1]로 선언
 * - 누적 합을 이용해 2차원 배열을 채움
 * - 각 행의 첫 번째 열은 이전 행의 마지막 열의 값을 넣어 완성
 * - 주어진 좌표값을 이용해 각 행별로 누적 합을 구해 더하면 완성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N+1][N+1];
        for (int i=1 ; i<N+1 ; i++) {
            String[] row = br.readLine().split(" ");
            for (int k=1 ; k<N+1 ; k++) {
                if (k==1) {
                    arr[i][k-1] = arr[i-1][N];
                }
                arr[i][k] = arr[i][k-1] + Integer.parseInt(row[k-1]);
            }
        }
        // 완성된 2차원 배열 출력용
        for (int i=0 ; i<N+1 ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        int[] result = new int[M];
        for (int i=0 ; i<M ; i++) {
            String[] xy = br.readLine().split(" ");
            int x1 = Integer.parseInt(xy[0]);
            int y1 = Integer.parseInt(xy[1]);
            int x2 = Integer.parseInt(xy[2]);
            int y2 = Integer.parseInt(xy[3]);

            while (x1 <= x2) {
                result[i] += arr[x1][y2] - arr[x1][y1-1];
                x1++;
            }
        }
        for (int i=0 ; i<M ; i++) {
            System.out.println(result[i]);
        }
    }
}
