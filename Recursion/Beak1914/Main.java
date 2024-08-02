package Recursion.Beak1914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger moveCount = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
        sb.append(moveCount).append('\n');

        if (N <= 20) {
            Hanoi(N, 1, 2, 3);
        }
        
        System.out.println(sb);
    }

    static void Hanoi(int N, int A, int B, int C) {
        if (N == 1) {
			sb.append(A + " " + C + "\n");
            return;
        }

        Hanoi(N-1, A, C, B);
        sb.append(A + " " + C + "\n");
        Hanoi(N-1, B, A, C);
    }
}