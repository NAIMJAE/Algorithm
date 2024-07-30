<<<<<<< HEAD
package DynamicProgramming.Beak1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.5]
 * 백준 1912 - 파도반 수열
 * https://www.acmicpc.net/problem/1912
 * 
 * <접근 방식>
 * - 연속된 두 수를 더하는 것이 아니라 연속되기만 하면 몇 개의 수를 더하든 상관 없음
 * - 고로 메모제이션을 통해 풀어야 함 (2차원 배열 or 어떠한 규칙)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        arr[0] = Integer.parseInt(input[0]);
        int result = 0;
        for (int i=1 ; i<N ; i++) {
            arr[i] = Integer.parseInt(input[i]) + Integer.parseInt(input[i-1]);
            if (i == 1) {
                result = arr[0];
            }
            if (arr[i] > arr[i-1]) {
                result = arr[i];
            }
        }
        System.out.println(result);
    }
}
=======
package DynamicProgramming.Beak1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [백준 DynamicProgramming 단계별로 풀기 step.5]
 * 백준 1912 - 파도반 수열
 * https://www.acmicpc.net/problem/1912
 * 
 * <접근 방식>
 * - 연속된 두 수를 더하는 것이 아니라 연속되기만 하면 몇 개의 수를 더하든 상관 없음
 * - 메모제이션을 통해 부분합을 저장하여 해결해야함
 * 
 * - for문에서 현재 주기의 최대값이 음수이면 현재 배열의 숫자로 초기화되는 규칙을 발견
 * - 이 방법으로 문제를 풀었는데 풀고 보니 Bottom-up 방식의 해결방법 이라고 함
 * 
 * <Bottom-up 방식>
 * - 문제를 작은 부분 문제로 나누고, 작은 문제부터 시작해서 점차 큰 문제로 확장해 나가며 해를 구함
 * 
 * <Top-down 방식>
 * - 큰 문제를 작은 부분 문제로 나누고, 재귀적으로 문제를 해결해 나감.
 * - 메모이제이션을 통해 이미 계산된 값은 저장하여 중복 계산을 피함
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int large = arr[0];
        int result = arr[0];

        // Bottom-up 방식: 첫 번째 요소부터 시작하여 전체 배열을 순회
        for (int i = 1; i < N; i++) {
            // 현재 연속된 숫자들의 합이 음수라면 현재 숫자로 초기화
            // 그렇지 않다면 현재 숫자를 더함
            if (large < 0) {
                large = arr[i];
            }else {
                large += arr[i];
            }
            
            // 최대 연속 부분 합을 업데이트
            if (large > result) {
                result = large;
            }
        }
        System.out.println(result);
    }
}
>>>>>>> 73f94b6150c17c936467ac023b9fd5d405a03a06
