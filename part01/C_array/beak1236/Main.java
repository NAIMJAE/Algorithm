package part01.C_array.beak1236;

import java.util.Scanner;

/**
 * 백준 1236번 - 성 지키기
 * https://www.acmicpc.net/problem/1236
 * - for문 1개 + 2중 for문 2개 = O(NM)의 시간복잡도
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] arr = new char[N][M];
        for (int i=0 ; i<N ; i++) {
            arr[i] = sc.next().toCharArray();
        }

        int existRowCount = 0;
        for (int i=0 ; i<N ; i++) {
            boolean exist = false;
            for (int j=0 ; j<M ; j++) {
                if (arr[i][j] == 'X') {
                    exist = true;
                    break;
                }
            }
            if (exist) { existRowCount++; }
        }

        int existColumnCount = 0;
        for (int i=0 ; i<M ; i++) {
            boolean exist = false;
            for (int j=0 ; j<N ; j++) {
                if (arr[j][i] == 'X') {
                    exist = true;
                    break;
                }
            }
            if (exist) { existColumnCount++; }
        }

        int needRowCoount = N - existRowCount; 
        int needColumnCoount = M - existColumnCount; 

        System.out.print(Math.max(needRowCoount, needColumnCoount));
    }
}
