package Beak11000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * 백준 11000번 - 강의실 배정
 * https://www.acmicpc.net/problem/11000
 * 
 * <접근 방법>
 * - 처음에는 강의정보자체를 우선순위큐에 넣어서 비교하려고 함
 * - 이 방법을 시도하니 겹치는 강의를 처리하기 위한 방법이 없었음
 * 
 * <해결 방법>
 * - 배열에 강의정보를 시작시간이 낮은 순서로 넣고 비교하기
 * - 현재 진행중인 수업의 종료시간과 다음 수업의 시작시간을 비교해 겹치면
 *   겹치는 강의의 종료시간을 우선순위 큐에 넣어두고 계속 비교를 반복
 * - 반복이 끝났을때 우선순위 큐에 들어있는 개수 = 강의장 개수
 */
class Lesson {
    int start;
    int end;

    Lesson(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public String toString() {
        return "Lesson{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();


        Lesson[] lessonArr = new Lesson[N];
        for (int i=0 ; i<N ; i++) {
            String input = sc.nextLine();
            int start = Integer.parseInt(input.split(" ")[0]);
            int end = Integer.parseInt(input.split(" ")[1]);
            lessonArr[i] = new Lesson(start, end);
        }

        Arrays.sort(lessonArr, Comparator.comparingInt(lesson -> lesson.start));


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lessonArr[0].end);

        for (int i = 1; i < N; i++) {
            // 우선순위 큐에서 시작시간이 가장 작은 종료 시간과
            // 현재 lessonArr[i]의 시작 시간을 비교한다.
            if (pq.peek() <= lessonArr[i].start) {
                pq.poll();
            }
            pq.offer(lessonArr[i].end);
        }

        System.out.println(pq.size());

        sc.close();
    }
}
