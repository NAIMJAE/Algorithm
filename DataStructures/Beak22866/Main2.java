package DataStructures.Beak22866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
/*
 * 시간 최적화를 위해서 매번 for문을 도는게 아니라
 * 처음에 for문을 돌며 각 위치별로 왼쪽 오른쪽에 보이는 건물수와 가장 가까운 건물의 번호를
 * 저장해둔 배열을 생성해 마지막에 두 배열을 돌며 보이는 건물 개수와 가까운 건물 번호를 출력
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] tower = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tower[i] = Integer.parseInt(input[i - 1]);
        }

        int[] size = new int[N + 1];
        int[] near = new int[N + 1];
        Arrays.fill(near, -1);
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        // 왼쪽 처리
        for (int i = 1; i <= N; i++) {
            while (!left.isEmpty() && tower[i] >= tower[left.peek()]) {
                left.pop();
            }
            size[i] = left.size();
            if (!left.isEmpty()) {
                near[i] = left.peek();
            }
            left.push(i);
        }

        // 오른쪽 처리
        for (int i = N; i > 0; i--) {
            while (!right.isEmpty() && tower[i] >= tower[right.peek()]) {
                right.pop();
            }
            size[i] += right.size();
            if (!right.isEmpty()) {
                if (near[i] == -1 || right.peek() - i < i - near[i]) {
                    near[i] = right.peek();
                }
            }
            right.push(i);
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            if (size[i] == 0) {
                System.out.println("0");
            } else {
                System.out.println(size[i] + " " + near[i]);
            }
        }
    }
}