package DataStructures.Beak24511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * [백준 DataStructures 단계별로 풀기 step.11]
 * 백준 24511번 - queuestack 
 * https://www.acmicpc.net/problem/24511
 * <접근 방법>
 * - 경우의 수를 따져보면 자료구조가 스택인 경우에는 삽입한 값을 그대로 반환하기 때문에 큐인 경우만 생각하면 됨
 * - 입력받은 값을 spilt하고 이중 for문으로 큐인 경우를 계산해서 제출 (시간 초과)
 * - 입력을 StringTokenizer로 변경하고 이중 for문으로 큐인 경우를 계산해서 제출 (시간 초과)
 * - 입력을 StringTokenizer로 하고 이중 for문인데 자료구조 사용 없이 계산해서 제출 (시간 초과)
 * - 결론적으로 이 문제에서 이중 for문을 사용하게 되면 시간 초과를 해결할 수 없음
 * - 스택은 생각하지 않고 큐인 경우만 생각하면 되므로 하나의 큐에 데이터를 순차적으로 넣어두고 뽑아내면 되는거였음
 * 
 * <풀이 방법>
 * - 자료구조의 종류를 저장하는 배열과 자료구조에 입력할 데이터를 저장하는 배열을 각각 생성
 * - 큐를 하나 만들어 자료구조가 큐이면 addFirst를 통해 데이터 삽입
 * - 그러고 for문에서 새로 입력하는 데이터를 add하고 pollFirst를 통해 정답 추출
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자료구조 개수
        int N = Integer.parseInt(br.readLine());

        // 자료구조의 종류
        int[] structure = new int[N];

        StringTokenizer input1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            structure[i] = Integer.parseInt(input1.nextToken());
        }

        // 자료구조의 초기값
        int[] data = new int[N];

        StringTokenizer input2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(input2.nextToken());
        }

        // 데이터를 삽입할 횟수
        int M = Integer.parseInt(br.readLine());

        // 삽입할 데이터
        int[] insert = new int[M];

        StringTokenizer input3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            insert[i] = Integer.parseInt(input3.nextToken());
        }

        // 큐 생성
        Deque<Integer> queue = new ArrayDeque<>();

        // 정답 출력용
        StringBuilder answer = new StringBuilder();

        // 계산 (큐 : 선입 선출 / 스택 : 후입 선출)
        for (int i = 0; i < N; i++) {
            if (structure[i] == 0) {
                queue.addFirst(data[i]);
            }
        }
        // queue : [ 4, 1 ]

        for (int i = 0; i < M; i++) {
            queue.add(insert[i]);
            answer.append((queue.pollFirst() + " "));
        }
        // queue : [ 4, 1, 2 ] -> [ 1, 2 ] / pop : 4
        // queue : [ 1, 2, 2 ] -> [ 2, 2 ] / pop : 1
        // queue : [ 2, 2, 7 ] -> [ 2, 7 ] / pop : 2

        System.out.println(answer);
        br.close();
    }
}