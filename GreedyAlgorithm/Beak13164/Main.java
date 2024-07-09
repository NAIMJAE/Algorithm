package GreedyAlgorithm.Beak13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 백준 13164번 - 행복 유치원
 * https://www.acmicpc.net/problem/13164
 * 
 * <접근 방법>
 * - 인접한 수들의 차이를 구해 값이 작은순으로 정렬
 * - 이때 작은 값들끼리 모아서 입력한 그룹의 개수로 분리하면 정답
 * - 그러기 위해 (num - group) 만큼 for문을 돌리는게 핵심 (이건 생각 못 했음)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int num = Integer.parseInt(input.split(" ")[0]);
        int group = Integer.parseInt(input.split(" ")[1]);

        String[] student = br.readLine().split(" ");
        int[] arr = new int[num];

        for (int i=0 ; i<num ; i++) {
            arr[i] = Integer.parseInt(student[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0 ; i<num-1 ; i++) {
            pq.offer(arr[i+1] - arr[i]);
        }
        System.out.println("pq : " + pq);

        int count = 0;
        for (int i=0 ; i<num - group ; i++) {
            count += pq.poll();
        }
        
        System.out.println("정답 : " + count);

    }
}