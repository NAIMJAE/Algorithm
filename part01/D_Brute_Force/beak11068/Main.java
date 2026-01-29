package part01.D_Brute_Force.beak11068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 11068번 - 회문인 수
 * https://www.acmicpc.net/problem/11068
 * - 문제에서 주어진 진법의 범위는 2 ~ 64 진법 사이
 * - 모든 입력값의 2 ~ 64 진법을 구해 회문인지 판단하는 방법도 있지만, 
 *   입력값들을 해당 진법으로 변환하기 위해 해당 진법으로 나누는 과정에서
 *   발생하는 나머지들만 배열로 모아서 비교하는 방법이 효율적 (구지 해당 진법 문자로 치환하지 않아도 됨)
 * - 회문인지 확인하기 위해 배열의 처음과 끝을 비교
 *   (진법마다 자리수가 다르니 배열의 크기가 아닌 실제 값이 들어있는 마지막 index를 구하는게 핵심)
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int x = Integer.parseInt(br.readLine());
            boolean ans = false;
            for (int i=2 ; i<=64 ; i++) {
                int[] digit = convert(x, i);
                if (isPalindrome(digit)) {
                    ans = true;
                    break;
                }
            }
            System.out.println(ans ? "1" : "0");
        }
    }

    public static int[] convert(int x, int i) {
        int len = 0;
        int copy = x;
        while (copy > 0) {
            copy /= i;
            len++;
        }

        int[] digit = new int[len];
        len = 0;
        while (x > 0) {
            digit[len++] = x % i;
            x /= i;
        }
        return digit;
    }

    public static boolean isPalindrome(int[] digit) {
        for (int i=0 ; i<digit.length/2 ; i++) {
            if (digit[i] != digit[digit.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
