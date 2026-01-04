package A1_implementation.baek1181;

import java.util.Scanner;

/**
 * 1181번 - 단어 정렬 [실5]
 * https://www.acmicpc.net/problem/1181
 * 
 * 사전순 정렬과 길이순 정렬 함수 전부 직접 구현 (정답은 맞지만 시간이 3배 더 걸림)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[] arr = new String[N];
        int size = 0;  // 현재까지 정렬되어 있는 원소 개수

        for (int i=0 ; i < N ; i++) {
            String word = sc.nextLine();

            // 삽입정렬 구현
            int pos = size;
            while (pos > 0 && compare(word, arr[pos - 1]) < 0) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = word;
            size++;
        }

        for (int i = 0; i < size; i++) {
            if (i > 0 && arr[i].equals(arr[i - 1])) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }

    // a가 앞에 와야 하면 음수 / b가 앞이면 양수 / 같으면 0
    public static int compare(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }
        return myCompare(a, b);
    }

    // 사전순 정렬 구현
    public static int myCompare(String a, String b) {
        int len = Math.min(a.length(), b.length());

        // 1) 앞에서부터 같은 인덱스의 문자 비교
        for (int i = 0; i < len; i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);

            if (ca != cb) {
                return ca - cb;  // 아스키 값(or 유니코드 값) 차이
            }
        }

        // 2) 여기까지 왔다면 앞부분은 모두 동일 → 길이가 짧은 문자열이 앞
        return a.length() - b.length();
    }
}
