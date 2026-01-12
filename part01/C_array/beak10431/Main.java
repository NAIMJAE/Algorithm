package part01.C_array.beak10431;

import java.util.Scanner;

/**
 * 백준 10431번 - 줄세우기
 * https://www.acmicpc.net/problem/10431
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();

        while (P-- > 0) {
            int T = sc.nextInt();
            int[] arr = new int[20];
            int totalSteps = 0;

            for (int i = 0; i < 20; i++) {
                int now = sc.nextInt();
                
                int pos = i;
                for (int j = 0; j < i; j++) {
                    if (arr[j] > now) {
                        pos = j;
                        totalSteps += (i - j);
                        
                        for (int k = i; k > pos; k--) {
                            arr[k] = arr[k - 1];
                        }
                        break;
                    }
                }
                arr[pos] = now;
            }
            System.out.println(T + " " + totalSteps);
        }
    }
}
