package GreedyAlgorithm.Beak13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 백준 13164번 - 행복 유치원
 * https://www.acmicpc.net/problem/13164
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

        int count = 0;
        for (int i=0 ; i<group ; i++) {
            count += pq.poll();
        }
        
        System.out.println("정답 : " + count);

    }
}