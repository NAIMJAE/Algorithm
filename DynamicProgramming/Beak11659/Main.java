package DynamicProgramming.Beak11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 11659번 - 구간  합 구하기 4
 * https://www.acmicpc.net/problem/11659
 * 
 * <접근 방법>
 * - 처음에는 i번부터 j번까지 for문을 통해 한 번씩 더하는 로직 구현 -> 시간초과
 * - 누적합 방식을 써서 for문을 최소화해 시간 통과
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] number = br.readLine().split(" ");

        int[] arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            if (i==0) {
                arr[i] = Integer.parseInt(number[i]);
            }else {
                arr[i] = arr[i-1] + Integer.parseInt(number[i]);
            }
        }

        int[] result = new int[M];
        for (int i=0 ; i<M ; i++) {
            String[] index = br.readLine().split(" ");
            int start = Integer.parseInt(index[0]);
            int end = Integer.parseInt(index[1]);
            if (start == 1) {
                result[i] = arr[end-1];
            }else {
                result[i] = arr[end-1] - arr[start-2];
            }
        }

        for (int i=0 ; i<M ; i++) {
            System.out.println(result[i]);
        }
    }
}
