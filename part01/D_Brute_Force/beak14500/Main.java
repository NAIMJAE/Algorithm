package part01.D_Brute_Force.beak14500;

import java.util.Scanner;

/**
 * 백준 14500번 - 테트로미노
 * https://www.acmicpc.net/problem/14500
 * - 일단 브루트포스로 생각하고, 모든 경우의 수를 하드코딩해서 탐색했음
 *   하지만 DFS를 이용하는게 정석이었던 방법
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // ㅁㅁㅁㅁ
                if (j+3 < M) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3]; 
                    max = Math.max(max, sum);
                }

                if (i+3 < N) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j]; 
                    max = Math.max(max, sum);
                }

                // ㅁㅁ
                // ㅁㅁ
                if (i+1 < N && j+1 < M) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1]; 
                    max = Math.max(max, sum);
                }

                // ㅁ     ㅁ  ㅁㅁ  ㅁㅁ
                // ㅁ     ㅁ    ㅁ  ㅁ    ㅁ        ㅁ  ㅁㅁㅁ  ㅁㅁㅁ
                // ㅁㅁ  ㅁㅁ    ㅁ  ㅁ   ㅁㅁㅁ  ㅁㅁㅁ  ㅁ         ㅁ
                if (i+2 < N && j+1 < M) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1]; 
                    max = Math.max(max, sum);

                    int sum2 = arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1]; 
                    max = Math.max(max, sum2);

                    int sum3 = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1]; 
                    max = Math.max(max, sum3);

                    int sum4 = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j]; 
                    max = Math.max(max, sum4);
                }

                if (i+1 < N && j+2 < M) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2]; 
                    max = Math.max(max, sum);

                    int sum2 = arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+2]; 
                    max = Math.max(max, sum2);

                    int sum3 = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j]; 
                    max = Math.max(max, sum3);

                    int sum4 = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2]; 
                    max = Math.max(max, sum4);
                }

                // ㅁ     ㅁ  
                // ㅁㅁ  ㅁㅁ    ㅁㅁ  ㅁㅁ    
                //   ㅁ  ㅁ    ㅁㅁ     ㅁㅁ  
                if (i+2 < N && j+1 < M) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1]; 
                    max = Math.max(max, sum);

                    int sum2 = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j]; 
                    max = Math.max(max, sum2);
                }

                if (i+1 < N && j+2 < M) {
                    int sum = arr[i][j+1] + arr[i][j+2] + arr[i+1][j] + arr[i+1][j+1]; 
                    max = Math.max(max, sum);

                    int sum2 = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2]; 
                    max = Math.max(max, sum2);
                }

                // ㅁㅁㅁ   ㅁ    ㅁ     ㅁ
                //   ㅁ   ㅁㅁㅁ  ㅁㅁ  ㅁㅁ
                //               ㅁ     ㅁ
                if (i+1 < N && j+2 < M) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]; 
                    max = Math.max(max, sum);

                    int sum2 = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2]; 
                    max = Math.max(max, sum2);
                }

                if (i+2 < N && j+1 < M) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1]; 
                    max = Math.max(max, sum);

                    int sum2 = arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1]; 
                    max = Math.max(max, sum2);
                }
            }
        }
        System.out.println(max);
    }
}
