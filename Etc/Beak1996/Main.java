package Etc.Beak1996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1996번 - 지뢰 찾기
 * https://www.acmicpc.net/problem/1996
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] game = new int[N][N];
        StringBuilder mine = new StringBuilder();
        
        for (int i=0 ; i<N ; i++) {
            mine.append(br.readLine());
        }

        int index = 0;
        for (int i=0 ; i<N ; i++) {
        
            for (int k=0 ; k<N ; k++) {
                char boom = mine.charAt(index++);
            
                if (boom == '.') {
                    //다음
                }else{
                    // 지뢰일때
                    
                    game[i][k] = -1;

                    if (i>=0 && k>=0) {

                    }

                    // 윗줄
                    game[i-1][k-1] += boom;
                    game[i-1][k] += boom;
                    game[i-1][k+1] += boom;
                    // 같은줄
                    game[i][k-1] += boom;
                    game[i][k+1] += boom;
                    // 아래줄
                    game[i+1][k-1] += boom;
                    game[i+1][k] += boom;
                    game[i+1][k+1] += boom;
                }
            }
        }
    }
}