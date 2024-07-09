package GreedyAlgorithm.Beak1052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1052번 -물병
 * https://www.acmicpc.net/problem/1052
 * 
 * <풀이 방법>
 * - 물병 개수를 2진법으로 나타냈을때 1의 개수는 한 번에 옮길 수 있는 물병 개수
 * - 이 1의 개수가 K보다 같거나 같을때 까지 N을 더하면 됨
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);

        int count = 0;

        while (Integer.bitCount(N) > K) {
            count++;
            N++;
        }
        System.out.println(count);
    }
}
