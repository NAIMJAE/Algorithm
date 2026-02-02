package part01.D_Brute_Force.beak1730;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 1730번 - 판화
 * https://www.acmicpc.net/problem/1730
 * - char[][] 배열이 아닌 booleanp[][] 배열을 이용하면 더 쉽게 풀 수 있었음
 * - 그리고 수직과 수평에 방문한 흔적을 따로 체크해서 출력시에 합치면 더 간단하게 풀 수 있었음
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line1 = br.readLine();
        if (line1 == null) return;
        int N = Integer.parseInt(line1);

        String str = br.readLine();
        if (str == null) str = "";

        boolean[][] boardV = new boolean[N][N]; // 수직
        boolean[][] boardH = new boolean[N][N]; // 수평

        int r = 0; // 행
        int c = 0; // 열

        for (int i = 0; i < str.length(); i++) {
            char d = str.charAt(i);

            if (d == 'D') {
                if (r == N - 1) continue;
                boardV[r][c] = boardV[r + 1][c] = true;
                r++;
            } else if (d == 'U') {
                if (r == 0) continue;
                boardV[r][c] = boardV[r - 1][c] = true;
                r--;
            } else if (d == 'L') {
                if (c == 0) continue;
                boardH[r][c] = boardH[r][c - 1] = true;
                c--;
            } else if (d == 'R') {
                if (c == N - 1) continue;
                boardH[r][c] = boardH[r][c + 1] = true;
                c++;
            }
        }

        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N ; j++) {
                if (boardV[i][j] && boardH[i][j]) {
                    System.out.print('+');
                } else if (boardV[i][j]) {
                    System.out.print('|');
                } else if (boardH[i][j]) {
                    System.out.print('-');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}
