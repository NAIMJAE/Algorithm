package part01.A_string.beak1919;

import java.util.Scanner;

/**
 * 백준 1919번 - 애너그램 만들기
 * https://www.acmicpc.net/problem/1919
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int[] str1Count = getAlphabetCount(str1);
        int[] str2Count = getAlphabetCount(str2);

        int result = 0;
        for (int i=0 ; i<26 ; i++) {
            result += Math.abs((str1Count[i] - str2Count[i]));
        }

        System.out.print(result);
    }

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i=0 ; i<str.length() ; i++) {
            char ch = str.charAt(i);
            count[ch - 'a']++;
        }
        return count;
    }
}
