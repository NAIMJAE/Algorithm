package part01.A_string.beak1157;

import java.util.Scanner;

/**
 * 백준 1157번 - 단어 공부
 * https://www.acmicpc.net/problem/1157
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] count = getAlphabetCount(str);

        int maxCount = -1;
        char maxAlphabet = '?';
        for (int i=0 ; i<count.length ; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlphabet = (char)('A'+i);
            } else if (count[i] == maxCount) {
                maxAlphabet = '?';
            }

        }
        System.out.print(maxAlphabet);
    }

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i=0 ; i<str.length() ; i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                count[ch - 'A']++;
            } else {
                count[ch - 'a']++;
            }
        }
        return count;
    }
}
