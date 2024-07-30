package DynamicProgramming.Beak1720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N이 홀수 / N이 짝수

        // | 타일만 쓰는 경우 (홀짝 모두 가능)

        // ㅡ 타일만 쓰는 경우 (짝만 가능)

        // ㅁ 타일만 쓰는 경우 (짝만 가능)

        // ㅁ | 타일을 쓰는 경우 (홀만 가능)

        // ㅁ ㅡ 타일을 쓰는 경우 (짝만 가능)

        // ㅁ | ㅡ 타일 모두 쓰는 경우 (홀만 가능)

        int count = 0;

        // case1
        count += N;

        if (N%2 == 0) {
            // case2
            count += N;
            // case3
            count += N/2;
            // case5
            if (N >= 4) {
                //2-0, 4-1, 6-4, 8-7, 10-8, 12-8
                // 1개짜리 나누기4에 올림
                // 2개짜리 
            }
            count += N/2;
            
        }


    }
}
