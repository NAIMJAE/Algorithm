package String.Beak9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 백준 9935번 - 문자열 폭발
 * https://www.acmicpc.net/problem/9935
 * 
 * <접근 방법>
 * - Split을 통해 폭탄으로 문자열을 문자열 배열로 자르고 다시 붙이고를 반복하는 방법 사용
 * - 배열과 String 객체를 계속 생성해야하고 반복문도 2번이라서 메모리초과로 실패
 * 
 * <풀이 방법>
 * - StringBuilder를 사용해 메모리 최적화
 * - StringBuilder는 Split을 제공하지 않기 때문에 다른방법을 사용
 * - input을 한글자씩 StringBuilder에 넣어 폭탄 문자 제거하는 방법
 * - StringBuilder 속에 (StringBuilder의 현재 길이) - (bomb의 길이) 에 해당하는 문자가
 *   bomb와 일치하는지 확인하며 for문 반복 -> 일치하면 delete로 제거
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String bomb = br.readLine();

        int bombLength = bomb.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if (sb.length() >= bombLength && sb.substring(sb.length() - bombLength).equals(bomb)) {
                sb.delete(sb.length() - bombLength, sb.length());
            }
        }
        
        if (sb.length() == 0) {
            bw.write("FRULA");
        } else {
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
