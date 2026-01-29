package part01.D_Brute_Force.beak3085;

import java.util.Scanner;

/**
 * 백준 3085번 - 사탕 게임
 * https://www.acmicpc.net/problem/3085
 * - 이 문제와 같이 2중 배열을 모두 순회하며 인접한 칸과 값을 비교하는 유형의 경우
 *   특정 칸을 기준으로 상,하,좌,우 4개의 칸을 비교해야 한다.
 * - 하지만 모든 칸을 인접한 4개의 칸과 비교하게되면 반드시 중복 비교하는 칸이 생기게 되며,
 *   효율적며, 중복 비교를 피하기 위해 index가 증가하는 방향만 비교하는 방법을 사용할 수 있다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[][] map = new char[N][N];
        for (int i=0 ; i<N ; i++) {
            map[i] = sc.next().toCharArray(); 
        }

        int result = 1;
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N ; j++) {
                if (i+1 < N && map[i][j] != map[i+1][j]) {
                    swap(map, i, j, i+1, j);
                    result = Math.max(result, Math.max(maxRow(map, N), maxColumn(map, N)));
                    swap(map, i, j, i+1, j);
                }

                if (j+1 < N && map[i][j] != map[i][j+1]) {
                    swap(map, i, j, i, j+1);
                    result = Math.max(result, Math.max(maxRow(map, N), maxColumn(map, N)));
                    swap(map, i, j, i, j+1);
                }
            }
        }
        System.out.println(result);
    }

    public static void swap(char[][] map, int i, int j, int x, int y) {
        char tmp = map[i][j];
        map[i][j] = map[x][y];
        map[x][y] = tmp;
    }

    public static int maxRow(char[][] map, int N) {
        int max = 1;
        for (int i=0 ; i<N ; i++) {
            int len = 1;
            for (int j=1 ; j<N ; j++) {
                
                if (map[i][j] == map[i][j-1]) {
                    len++;
                } else {
                    max = Math.max(max, len);
                    len = 1;
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }

    public static int maxColumn(char[][] map, int N) {
        int max = 1;
        for (int i=0 ; i<N ; i++) {
            int len = 1;
            for (int j=1 ; j<N ; j++) {
                
                if (map[j][i] == map[j-1][i]) {
                    len++;
                } else {
                    max = Math.max(max, len);
                    len = 1;
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
