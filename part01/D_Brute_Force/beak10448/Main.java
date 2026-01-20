package part01.D_Brute_Force.beak10448;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준 10448번 - 유레카 이론
 * https://www.acmicpc.net/problem/10448
 * - 시간복잡도 O(N * (idx + idx^3))
 * - 이 코드가 완전 탐색의 가장 기본적인 형태
 * - 조금 더 시간복잡도를 적게 가져가려면 모든 삼각수와 삼각수의 값들을 미리 계산해두고 사용하기
 * --> 전처리 과정을 통해 O(idx + idx^3 + N) 으로 줄일 수 있음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i=0 ; i<N ; i++) {
            int M = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(makeArr(M)) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int makeArr(int M) {
        int[] arr = new int[45];
        int idx = 0;
        for(int i=1 ; i<arr.length ; i++) {
            int num = (i * (i+1)) / 2;
            if (num >= M) { break; }
            arr[idx++] = num;
        }

        return checkSum(arr, M, idx);
    }

    public static int checkSum(int[] arr, int M, int idx) {
        for(int i=0 ; i<idx ; i++) {
            for(int j=0 ; j<idx ; j++) {
                for(int k=0 ; k<idx ; k++) {
                    if (M == arr[i] + arr[j] + arr[k]) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
