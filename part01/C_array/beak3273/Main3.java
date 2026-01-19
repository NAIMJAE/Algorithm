package part01.C_array.beak3273;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
/**
 * 백준 3273번 - 두 수의 합
 * HashSet 풀이
 */
public class Main3 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        HashSet<Integer> set = new HashSet<>();
        int[] numbers = new int[N]; // 입력 순서를 기억하기 위한 배열 (또는 다른 방식으로 구현 가능)
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            set.add(numbers[i]);
        }
        int X = Integer.parseInt(br.readLine());

        int count = 0;
        // 저장된 숫자들을 순회하며 짝이 있는지 확인
        for (int num : numbers) {
            int needed = X - num;
            
            // 짝이 존재하고, 그 짝이 자기 자신(num)이 아닌 경우
            if (set.contains(needed) && needed != num) {
                count++;
            }
        }

        // 쌍 (a, b)와 (b, a)가 두 번 카운트되므로 2로 나눔
        bw.write(String.valueOf(count / 2));
        bw.flush();
        bw.close();
        br.close();
    }
}
