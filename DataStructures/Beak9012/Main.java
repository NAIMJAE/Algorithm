package DataStructures.Beak9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * [백준 DataStructures 단계별로 풀기 step.3]
 * 백준 9012번 - 괄호
 * https://www.acmicpc.net/problem/9012
 * <접근 방법>
 * - stack 에 현재 문자를 반복해서 넣고 ()가 완성되면 pop
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] result = new String[N];
        Stack<Character> stack = new Stack<>();

        for (int i=0 ; i<N ; i++) {
            char[] input = br.readLine().toCharArray();;
            for (int k=0 ; k<input.length ; k++) {

                if (!stack.empty() && stack.peek() == '(') {
                    if (input[k] == ')') {
                        stack.pop();
                    }else {
                        stack.push(input[k]);
                    }
                }else {
                    stack.push(input[k]);
                }
            }
            if (!stack.isEmpty()) {
                result[i] = "NO";
                stack.clear();
            }else {
                result[i] = "YES";
            }
        }

        for (int i=0 ; i<N ; i++) {
            System.out.println(result[i]);
        }
    }
}
