package DataStructures.Beak2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * [백준 DataStructures 단계별로 풀기 step.11]
 * 백준 12789번 - 도키도키 간식드리미
 * https://www.acmicpc.net/problem/2164
 * <접근 방법>
 * - 덱을 이용해 카드를 버리고 아래로 옮기고 반복
 * 
 * - 근데 이 문제 수학적 규칙이 있어서 시간 단축 엄청 가능...
 * - 2의 제곱수일 때는 자기 자신이 마지막에 남음
 * - 그 외에는 자기보다 작은 2의 제곱수로부터 몇번째인지에 2를 곱한 값이 마지막에 남게 됨
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> cards = new ArrayDeque<>();
        for (int i=0 ; i<N ; i++) {
            cards.push(i+1);
        }

        while (cards.size() != 1) {
            // 카드 버리기
            cards.pollLast();
            // 아래로 옮기기
            cards.addFirst(cards.pollLast());
        }
        System.out.println(cards.pollLast());
    }
}
