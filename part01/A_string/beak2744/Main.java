package part01.A_string.beak2744;

import java.util.Scanner;

/**
 * 백준 2744번 - 대소문자 바꾸기
 * https://www.acmicpc.net/problem/2744
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        char[] result = new char[input.length()];
        for (int i=0 ; i<input.length() ; i++) {
            char C = input.charAt(i);
            if (Character.isUpperCase(C)) {
                result[i] = Character.toLowerCase(C);
            }else {
                result[i] = Character.toUpperCase(C);
            }
        }

        System.out.print(new String(result));
    }
}