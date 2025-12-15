package A1_implementation.baek2941;

import java.util.Scanner;

/**
 * 2941번 - 크로아티아 알파벳 [실5]
 * https://www.acmicpc.net/problem/2941
 * 
 * role 배열을 만들어서 문자를 비교하는 시도를 했지만, 이 방법은 일반 문자를 정확하게 걸러내지 못했음
 * 오히려 단순하게 생각했으면 쉽게 풀었을 문제
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            // 3글자 패턴: dz=
            if (i + 2 < len && s.charAt(i) == 'd') {
                if (s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
                    count++;
                    i += 2;  // dz= 건너뛰기
                    continue;
                }
            }

            // 2글자 패턴들
            if (i + 1 < len) {
                String two = s.substring(i, i + 2);

                if (two.equals("c=")
                        || two.equals("c-")
                        || two.equals("d-")
                        || two.equals("lj")
                        || two.equals("nj")
                        || two.equals("s=")
                        || two.equals("z=")) {

                    count++;
                    i += 1;  // 2글자 패턴 건너뛰기
                    continue;
                }
            }

            // 일반 문자 1개
            count++;
        }

        System.out.println(count);
    }
}
