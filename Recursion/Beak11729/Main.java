package Recursion.Beak11729;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * [백준 Recursion 단계별로 풀기 step.7]
 * 백준 11729번 - 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729
 * 
 * <접근 방벙>
 * - 먼저 N에 따른 총 이동 횟수는 규칙을 가지고 증가함
 * - 1, 3, 7, 15 ... -> 앞의 횟수에 2의 N제곱만큼 더해서 증가하는 규칙
 * - 처음에는 이 규칙을 이용해서 재귀함수를 만들었지만 그러면 N이 홀수일 때와 짝수일 때 사용해야하는 함수가 달라지는 문제
 * - 다른 방식을 찾다가 재귀함수를 2번씩 부르는 함수 제작
 * - 이동하는 순서를 나열해서 중간값을 보면 항상 [1 3]이 나옴
 * - 이를 근거로 계속해서 반으로 나눠서 이동시키고 출력하는 방법을 채택
 */
class Floor {
    int A;
    int B;

    Floor(int A, int B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public String toString() {
        return A + " " + B;
    }
}

public class Main {
    static List<Floor> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Hanoi(N, 1, 2, 3);

        bw.write(result.size() + "\n");
        for (Floor floor : result) {
            bw.write(floor + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void Hanoi(int N, int A, int B, int C) {
        if (N == 1) {
            result.add(new Floor(A, C));
            return;
        }

        Hanoi(N-1, A, C, B);
        result.add(new Floor(A, C));
        Hanoi(N-1, B, A, C);
    }
}
