package part01.C_array.beak3273;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 백준 3273번 - 두 수의 합
 * 투 포인터(Two Pointers) 알고리즘 정리
 * - 선형 구조(배열, 리스트 등)에서 두 개의 포인터(인덱스)를 사용하여 특정 조건을 만족하는 원소 쌍이나 부분 배열을 찾는 효율적인 알고리즘
 * - 탐색을 시작할 때 배열이 반드시 정렬되어 있어야 함
 * 
 * - 이중 반복문(O(N^2))이 필요한 문제를 정렬 시간 포함 O(N log N) 또는 탐색 자체는 O(N) 시간에 해결할 수 있음
 * - 추가적인 자료구조(해시 맵 등)를 거의 사용하지 않고 상수 수준의 메모리(O(1))만 사용
 * - 정렬된 배열에서 특정 합/차/곱을 가지는 두 원소의 쌍을 찾아야 할 때 가장 유용
 * - 투 포인터 코드: (O(N log N))
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        // 1. 배열 정렬
        Arrays.sort(numbers);

        int count = 0;
        int left = 0; // 시작 포인터
        int right = N - 1; // 끝 포인터

        // 2. 투 포인터 알고리즘 수행
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == X) {
                // 합이 X와 같으면 쌍을 찾았으므로 카운트 증가
                count++;
                // 다음 쌍을 찾기 위해 양쪽 포인터 모두 이동
                left++;
                right--;
            } else if (currentSum < X) {
                // 합이 X보다 작으면 더 큰 수를 더해야 하므로 왼쪽 포인터 이동
                left++;
            } else {
                // 합이 X보다 크면 더 작은 수를 더해야 하므로 오른쪽 포인터 이동
                right--;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
