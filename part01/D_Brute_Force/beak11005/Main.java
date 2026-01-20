package part01.D_Brute_Force.beak11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 11005번 - 진법 변환2
 * https://www.acmicpc.net/problem/11005
 * - 10진수 N을 B진법으로 바꾼다는 것은, N을 B의 거듭제곱(멱수)들의 합으로 분해하는 과정
 * - N을 B로 나누어 나머지를 출력하고, 몫은 계속 B로 나누어야 함 
 * - 이때, 나머지를 역수로 출력하는 것이 핵심
 * 
 * - 시간복잡도는 O(log_M N) - (급격한 상승 후 완만한 증가)
 * - 어떤 수 N을 M으로 계속 나누어 0이 될 때까지 걸리는 단계의 수는 수학적으로 (log_M N)에 비례
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            int Y = N % M;
            
            if (Y < 10) {
                sb.append(Y);
            } else {
                sb.append((char) ('A' + (Y - 10)));
            }

            N /= M;
        }
        System.out.println(sb.reverse().toString());
    }
}
