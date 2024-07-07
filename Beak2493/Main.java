package Beak2493;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 * 5 7 4 9 3 1 8
 * 6 9 5 7 4
 */

public class Main {
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
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < topNum; i++) {
            while (!stack.isEmpty() && topArr[stack.peek()] <= topArr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                resArr[i] = stack.peek() + 1;
            } else {
                resArr[i] = 0;
            }
            stack.push(i);
        }

        System.out.println("보내는 탑 : " + Arrays.toString(topArr));
        System.out.println("수신한 탑 : " + Arrays.toString(resArr));

        for (int i = 0; i < resArr.length; i++) {
            System.out.print(resArr[i] + " ");
        }

    }
}
