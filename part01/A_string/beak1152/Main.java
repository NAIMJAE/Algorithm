package part01.A_string.beak1152;

import java.util.Scanner;
/**
 * 백준 1152번 - 단어의 개수
 * https://www.acmicpc.net/problem/1152
 * - StringTokenizer st = new StringTokenizer(str, " "); 가 있음
 * - 연속된 공백이나 앞뒤 공백을 무시하고 '토큰'만 추출
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] arr = str.split(" ");
        
        int count = 0;
        for (String string : arr) {
            if (!string.equals("")) { count++; }
        }

        System.out.println(count);
    }
}
