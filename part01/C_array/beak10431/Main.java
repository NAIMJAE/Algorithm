package part01.C_array.beak10431;

import java.util.Scanner;

/**
 * 백준 10431번 - 줄세우기
 * https://www.acmicpc.net/problem/10431
 * - 전체 시간 복잡도: O(P * N^2) (P: 테스트 케이스 수, N: 학생 수 20명)
 * 
* - 각 학생이 줄을 설 때마다 '자기 앞에 서 있는 모든 학생'과 비교함
 * - 문제에서 N을 20으로 제한했으나, 내부 반복문의 횟수가 고정 상수가 아니라 
 *   N의 크기에 종속되어 가변적으로 증가하는 '삽입 정렬' 구조이므로 O(N^2)임
 * - N이 작기 때문에(20) O(N^2) 로직으로도 시간 제한 내에 충분히 해결 가능함
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();

        while (P-- > 0) {
            int T = sc.nextInt();
            int[] arr = new int[20];
            int totalSteps = 0;

            for (int i = 0; i < 20; i++) {
                int now = sc.nextInt();
                
                int pos = i;
                for (int j = 0; j < i; j++) {
                    if (arr[j] > now) {
                        pos = j;
                        totalSteps += (i - j);
                        
                        for (int k = i; k > pos; k--) {
                            arr[k] = arr[k - 1];
                        }
                        break;
                    }
                }
                arr[pos] = now;
            }
            System.out.println(T + " " + totalSteps);
        }
    }
}
