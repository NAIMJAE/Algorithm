package A2_simulation.baek16234;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 16234번 - 인구 이동
 * https://www.acmicpc.net/problem/16234
 * - 풀지 못함 / BFS/DFS 탐색 개념 이해 및 활용 부족
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 행열
        int L = sc.nextInt(); // 인구 차이 MAX
        int R = sc.nextInt(); // 인구 차이 MIN

        int[][] arr = new int[N][N];
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        List<int[]> U = new ArrayList<>();
        while (true) {

        }

    }
}
