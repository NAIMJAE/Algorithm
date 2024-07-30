package String.Beak1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 백준 1213번 - 팰린드롬 만들기
 * https://www.acmicpc.net/problem/1213
 * <접근 방법>
 * - 우선 순위 큐에 문자를 넣어두고 하나씩 꺼내서 팰린드롬 만들기
 * - 알파벳이 홀수개인 경우가 2가지 이상 존재하면 만들 수 없는 반례를 생각 못해서 틀림
 * - 반례처리때문에 실버3치곤 매우 어려웠음
 * 
 * <풀이 방법>
 * - HashMap에 넣어서 입력한 문자의 알파벳 개수 세기 (홀수개가 2개이상이면 return)
 * - 홀수개인 알파벳은 mid에 저장해두고 마지막에 합치기
 * - 우선 순위큐에 HashMap을 넣어두고 팰린드롬 절반 만들기
 * - 절반의 팰린드롬에 mid 합치고 절반을 뒤집어서 팰린드롬 완성하기
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0 ; i<input.length() ; i++) {
            char c = input.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int check = 0;
        char mid = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                check++;
                mid = entry.getKey();
            }
        }

        if (check > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(countMap.keySet());

        StringBuilder half = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < countMap.get(c) / 2; i++) {
                half.append(c);
            }
        }

        StringBuilder result = new StringBuilder(half);
        if (mid != 0) {
            result.append(mid);
        }
        result.append(half.reverse());

        System.out.println(result.toString());
    }
}