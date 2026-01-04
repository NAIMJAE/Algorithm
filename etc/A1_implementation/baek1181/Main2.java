package A1_implementation.baek1181;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 1181번 - 단어 정렬 [실5]
 * https://www.acmicpc.net/problem/1181
 * 
 * Collections 함수를 사용하는 방법
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextLine());
        }

        // Collections.sort 두 번째 인자는 비교 함수(Comparator) / 리턴값은 int
        // a.length() - b.length() / 음수면 a가 앞 / 양수면 b가 앞
        Collections.sort(list, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b); // 길이 같으면 사전순
        });

        for (int i=0 ; i<list.size() ; i++) {
            if (i > 0 && list.get(i).equals(list.get(i-1))) {
                continue;
            }
            System.out.println(list.get(i));
        }
    }
}
