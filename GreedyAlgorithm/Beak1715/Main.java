package GreedyAlgorithm.Beak1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
 * 백준 1715번 - 카드 정렬하기
 * https://www.acmicpc.net/problem/1715
 * 
 * <접근 방법>
 * - 카드 묶음을 합칠때 최소 비교 횟수를 구하기 위해서는 카드 묶음이 작은 순으로 더하면 됨
 * - 우선순위 큐에 카드 묶음을 넣어 작은 순서대로 더하고
 *   더한 값을 다시 우선순위 큐에 넣어 반복하면 정답
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0 ; i<N ; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (pq.size() > 1) {
            int M = pq.poll();
            int O = pq.poll();
            int P = M + O;
            pq.add(P);
            count += P;
        }
        System.out.println(count);
    }
}
