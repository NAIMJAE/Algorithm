package Baek27522;

import java.util.Scanner;
import java.util.Arrays;

/*
 * 백준 27522번 - 카트라이더: 드리프트
 * https://www.acmicpc.net/problem/27522
 */
/*
<입력 예제>
1:52:682 B
1:50:201 R
1:49:003 B
1:49:735 B
1:50:257 R
1:51:134 R
1:49:236 R
1:53:932 B
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 시간과 팀을 입력 받은 후 각각 times와 teams 배열에 저장
        int[] scores = {10, 8, 6, 5, 4, 3, 2, 1, 0};
        int[] times = new int[8];
        char[] teams = new char[8];

        for(int i = 0; i < 8; i++) {
            String testCase = sc.nextLine().trim();
            times[i] = Integer.parseInt(testCase.replaceAll("[^0-9]", ""));
            teams[i] = testCase.charAt(testCase.length() - 1);
        }
        sc.close();

        // times 배열을 비교후 삽입정렬로 시간이 빠른순서로 정렬
        // 이때 teams 배열도 같이 정렬 

        System.out.println("start : " + Arrays.toString(times));
        System.out.println("start : " + Arrays.toString(teams));
        for (int i=1 ; i < times.length ; i++) {
            int timeKey = times[i];
            char teamKey = teams[i];
            int j = i-1;
            while (j >= 0 && times[j] > timeKey) {
                times[j+1] = times[j];
                teams[j+1] = teams[j];
                j = j-1;
            }
            times[j+1] = timeKey;
            teams[j+1] = teamKey;
        }
        System.out.println("end : " + Arrays.toString(times));
        System.out.println("end : " + Arrays.toString(teams));

        // red팀과 blue팀의 순위에 따른 score 합산
        int redTeamScore = 0;
        int blueTeamScore = 0;

        for (int i=0; i < teams.length ; i++) {
            if (teams[i] == 'R') {
                redTeamScore += scores[i];
            } else {
                blueTeamScore += scores[i];
            }
        }

        // 합산 score가 더 높은 팀 출력
        if (redTeamScore > blueTeamScore) {
            System.out.println("Red");
        }else {
            System.out.println("Blue");
        }
    }
}