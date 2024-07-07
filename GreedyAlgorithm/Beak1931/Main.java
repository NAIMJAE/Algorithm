package GreedyAlgorithm.Beak1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 1931번 - 회의실 배정
 * https://www.acmicpc.net/problem/1931
 * <접근 방법>
 * - 11000번 강의실 배정처럼 우선순위 큐를 사용했으나 2차원 배열은 한 번도 안써봐서 변경
 * - 2차원 배열을 쓰면 start,end를 저장하기 위한 객체를 만들지 않아도 됨
 * - 수업정보를 끝나는 시간 기준으로 정렬하게 되면 쉽게 풀리는 문제
 * 
 * - "서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다는 것"
 * 
 * 이러한 유형의 문제를 '활동 선택 문제(Activity Selection problem)'라고 함
 * 한 사람이 하나의 활동에 대해서만 작업할 수 있을 때 최대한 많은 활동을 할 수 있는 수를 선택하는 문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // N개의 회의 + 2개의 시간(start, end)
        int[][] time = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료
        }

        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) { //종료시간이 같을 경우 시작 시간이 빠른 순
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int cnt = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            if(end <= time[i][0]) {
                end = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
