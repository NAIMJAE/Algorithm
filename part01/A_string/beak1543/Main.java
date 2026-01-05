package part01.A_string.beak1543;

import java.util.Scanner;
/**
 * 백준 1543번 - 문서 검색
 * https://www.acmicpc.net/problem/1543
 * - String.indexOf(word, index); 으로 더 간단하게 풀이 가능
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String trg = sc.nextLine();
        int N = trg.length();

        int i = 0;
        int c = 0;
        while (str.length() >= i + N) {
            String slice = str.substring(i, i+N);
            if (slice.equals(trg)) {
                i = i + N;
                c++;
            } else {
                i++;
            }
        }
        System.out.println(c);
    }
}
