package dp.Beak1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][];

        for (int i=0 ; i<N ; i++) {
            arr[i] = new int[i+1];
            String[] input = br.readLine().split(" ");
            for (int k=0 ; k<=i ; k++) {
                arr[i][k] = Integer.parseInt(input[k]);
            }
        }

        int[] sum = new int[N];
        for (int i=0 ; i<N ; i++) {
            System.out.println("for 시작 : " + Arrays.toString(sum));
            int F = N-1;
            int B = i;
            int count = arr[F][B];
            while (F > 0) {
                System.out.println("F : " + F + " | B : " + B + " | count : " + count);
                int M = 0;
                if (B == 0) {
                    M = arr[F-1][B]; 
                }else if (F == B) {
                    M = arr[F-1][B-1];
                    B--;
                }else {
                    int C = arr[F-1][B-1];
                    int D = arr[F-1][B];
                    if (C > D) {
                        M += C;
                        B--;
                    }else if(C == D) {
                        // ??
                    }else {
                        M += D;
                    }
                }
                count += M;
                F--;
            }
            sum[i] = count;
        }

        int max = 0;
        for (int i=1 ; i<sum.length ; i++) {
            if (Math.max(sum[i-1], sum[i]) > max) {
                max = Math.max(sum[i-1], sum[i]);
            }
        }
        System.out.println("결과 : " + max);
    }
}
