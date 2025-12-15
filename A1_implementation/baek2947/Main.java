package A1_implementation.baek2947;

import java.util.Scanner;

/**
 * 2947번 - 나무 조각
 * https://www.acmicpc.net/problem/2947
 * - 유틸 함수까지 잘 만들어두고 정렬이 이루어지지 않았을때, 처음으로 돌아가는걸 생각 못함
 * - while문을 쓰고 check()를 조건으로 달면 쉬웠는데, 어렵게 생각함
 */
public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        int[] arr = new int[s.length];
        for (int i=0 ; i<s.length ; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        while (!check(arr)) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    print(arr);
                }
            }
        }
    }

    public static void print(int[] arr) {
        for (int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i]);
            if (i < arr.length-1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    };

    public static boolean check(int[] arr) {
        for (int i=0 ; i<arr.length-1 ; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    };
}
