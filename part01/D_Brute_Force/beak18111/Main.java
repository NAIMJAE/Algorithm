package part01.D_Brute_Force.beak18111;
/**
 * 백준 18111번 - 마인크래프트
 * https://www.acmicpc.net/problem/18111
 * - 아직 모든 경우를 다 계산하는게 어색하고, 감이 안옴
 *   어떻게든 최적화해서 정답을 구할 수 없을까를 먼저 생각하게 됨
 * - 처음에는 입력값을 2중 배열에 넣어 풀었지만, 그러면 3중 반복문이 나와 시간초과하게 됨
 * - 입력값을 각 높이에 해당하는 블럭의 개수를 저장하는 방식으로 변경해, 연산 시간을 줄임
 *
 * - 시간복잡도 계산
 *   - 첫번째 for문은 최대 500 * 500 번 -> O(NM)
 *   - 두번째 2중 for문 256 * 256 번 고정 -> O(H^2)
 *   - 처음 방법은 3중 for문 때문에 O(HNM) 의 시간복잡도가 나옴 
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int B = sc.nextInt();
        
        int[] counts = new int[257];
        int minH = 256;
        int maxH = 0;

        for (int i = 0; i < N * M; i++) {
            int h = sc.nextInt();
            counts[h]++;
            if (h < minH) minH = h;
            if (h > maxH) maxH = h;
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;
        for (int target = minH; target <= maxH; target++) {
            int removeCount = 0; // 제거할 블럭수
            int addCount = 0; // 추가할 블럭수

            for (int cur = minH; cur <= maxH; cur++) {
                if (counts[cur] == 0) continue; // 해당 높이의 땅이 없음

                if (cur > target) {
                    // 제거하기
                    removeCount += (cur - target) * counts[cur];
                } else if (cur < target) {
                    // 추가하기
                    addCount += (target - cur) * counts[cur];
                }
            }

            // 가능환 경우 확인
            if (addCount <= removeCount + B) {
                int time = (removeCount * 2) + addCount;
                if (time <= minTime) {
                    minTime = time;
                    height = target;
                }
            }
        }

        System.out.println(minTime + " " + height);
    }
}
