package Beak2493;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 시간 초과로 실패한 코드
 * - for문의 while에서 최악의 경우 왼쪽에 있는 모든 탑을 순회해야하는 경우가 있음
 * 
 * - 현재 코드는 모든 탑에 대해 이전 탑들을 하나씩 검사하기 때문에 O(N^2)의 시간 복잡도를 가짐
 * - 스택을 이용한 코드는 각 탑을 한 번씩만 처리하고 필요 없는 비교를 피하기 때문에 O(N)의 시간 복잡도를 가짐
 */
public class Fail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("타워 개수 : ");
        int topNum = sc.nextInt();
        sc.nextLine();

        int[] topArr = new int[topNum];
        String[] topLine = sc.nextLine().split(" ");
        for (int i=0 ; i<topNum ; i++) {
            topArr[i] = Integer.parseInt(topLine[i]);
        }

        int[] resArr = new int[topNum];
        int k = 0;
        Boolean res = false;
        for (int i=0 ; i<topNum ; i++) {
            k = i-1;
            while (!res && k>=0) {
                if (topArr[k] >= topArr[i]) {
                    resArr[i] = k + 1;
                    res = true;
                }else {
                    k--;
                }
            }
            if (res) {
                res = false;
                continue;
            }else {
                resArr[i] = 0;
            }
        }
        System.out.println("보내는 탑 : " + Arrays.toString(topArr));
        System.out.println("수신한 탑 : " + Arrays.toString(resArr));

        for (int i = 0; i < resArr.length; i++) {
            System.out.print(resArr[i] + " ");
        }
    }
}
