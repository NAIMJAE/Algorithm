package DynamicProgramming.Beak1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.3]
 * 백준 1904번 - 01타일
 * https://www.acmicpc.net/problem/1904
 * 
 * - 인터넷 풀이법에서 for문이 아닌 재귀함수 호출로 풀 수 있다고해서 작성
 * - 재귀는 속도 324ms / for문은 속도 120ms
 */
public class Main2 {
    
    public static int[] arr = new int[1000001];;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;

        for(int i = 3; i < arr.length; i++) {
			arr[i] = -1;
		}

        System.out.println(Tile(N));;
    }
    public static int Tile(int N) {

        if (arr[N] == -1) {
            arr[N] = (Tile(N - 1) + Tile(N - 2)) % 15746;
        }
        return arr[N];
    }
}