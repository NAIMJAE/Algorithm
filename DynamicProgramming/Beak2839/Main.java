package DynamicProgramming.Beak2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 백준 2839번 - 설탕 배달
 * https://www.acmicpc.net/problem/2839
 * 
 * <접근 방법>
 * - 2차원 배열을 이용해 이진트리로 풀었으나 시간 초과로 실패
 * - 실버4 문제인데 너무 어렵게 생각함
 * - 손으로 25까지 5로 나눈 목과 나머지 그리고 필요한 봉투의 개수를 다 적어보면 규칙이 보임 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N==4 || N==7) {
            System.out.println(-1);
        }else if (N%5 == 1) {
            System.out.println(2 + (N/5 - 1));
        }else if (N%5 == 2) {
            System.out.println(4 + (N/5 - 2));
        }else if (N%5 == 3) {
            System.out.println(1 + N/5);
        }else if (N%5 == 4) {
            System.out.println(3 + (N/5 - 1));
        }else if (N%5 == 0) {
            System.out.println(N/5);
        }
    }
}
