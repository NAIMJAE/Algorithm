package String.Beak15927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 15927번 - 회문은 회문아니야!!
 * https://www.acmicpc.net/problem/15927
 * <접근 방법>
 * - StringBuilder를 이용해 문자열을 거꾸로 뒤집은 것과 비교해 해결하려 했지만
 *   ZZZZZ 와 같은 예외를 처리할 마땅한 방법을 찾을 수 없었음
 * 
 * <풀이 방법>
 * - for문에서 return을 사용해 메서드를 끝내버리는 방법을 이용해 회문이 아닌경우 출력
 * - boolean 값을 이용해 회문인 경우와 ZZZZZ와 같은 예외 출력 처리
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();

        boolean result = true;
        for(int i=0 ; i<len/2 ; i++) {
            if (input.charAt(i) != input.charAt(len-1-i)) {
                System.out.println(input.length());
                return;
            }
            if (input.charAt(i) != input.charAt(i+1)) {
                result = false;
            }
        }
        
        if(result) {
            System.out.println(-1);
        }else {
            System.out.println(input.length()-1);
        }
    }
}
