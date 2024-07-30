package BinarySearch.Beak2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2805번 - 나무 자르기
 * https://www.acmicpc.net/problem/2805
 * 
 * <접근 방법>
 * - 가장 길이가 긴 나무의 길이로 H를 설정한 이후
 *   for문을 통해 1씩 줄여가며 M을 만족하는 경우의 수 찾기 -> 시간초과
 * 
 * <풀이 방법>
 * - 입력 받은 나무의 높이 중 가장 큰 나무의 높이를 찾은 다음 이진 탐색을 통해 정답 찾기
 * - 그런데 문제의 조건이 (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000) 이라서 sum에 long 타입을 써야 했음
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("나무 개수 / 필요한 나무 길이 입력");
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        System.out.println("나무 높이 입력");
        int[] wood = new int[N];
        int max = 0;
        String[] tree = br.readLine().split(" ");
        for (int i=0 ; i<N ;i++) {
            wood[i] = Integer.parseInt(tree[i]);
            if (wood[i] > max) {
                max = wood[i];
            };
        }

        // 가장 큰나무와 가장 작은 나무의 중간값으로 이분 탐색
        int start = 0;
        int end = max;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for (int i=0 ; i<N ; i++) {
                if (wood[i] > mid) {
                    sum += wood[i] - mid;
                }
                System.out.println("result : " + result + " | start : " + start + " | end : " + end + " | wood[i] : " + wood[i] + " | sum : " + sum);
            }
            if (sum == M) {
                result = mid;
                break;
            }else if (sum > M) {
                result = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}