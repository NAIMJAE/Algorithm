package DataStructures.Beak28278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * [백준 DataStructures 단계별로 풀기 step.1]
 * 백준 28278번 - 스택 2
 * https://www.acmicpc.net/problem/28278
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "1":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "2":
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
                case "3":
                    sb.append(stack.size()).append('\n');
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                        sb.append(0).append('\n');
                    } else {
                        sb.append(1).append('\n');
                    }
                    break;
                case "5":
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
