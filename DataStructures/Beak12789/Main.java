package DataStructures.Beak12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * [백준 DataStructures 단계별로 풀기 step.5]
 * 백준 12789번 - 도키도키 간식드리미
 * https://www.acmicpc.net/problem/12789
 * <접근 방법>
 * - 기존의 대기줄 line
 * - 추가 대기줄 stack
 * - 각 스택의 peek를 확인해 현재 번호와 일치하면 pop
 * - line의 peek를 확인해 현재 번호와 일치하지 않으면 stack로 이동
 * - line가 비어있고 stack의 peek가 현재 번호와 일치하지 않으면 break와 Sad 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Stack<Integer> line = new Stack<>();
        for (int i=N-1 ; i>=0 ; i--) {
            line.push(Integer.parseInt(input[i]));
        }

        Stack<Integer> stack = new Stack<>();
        String result = "Nice";
        int count = 1;

        while (count <= N) {

            if (!line.isEmpty() && !stack.isEmpty()) {
                System.out.println("count : " + count + " | line : " + line.peek() + " | stack : " + stack.peek());
            }else if (!line.isEmpty() && stack.isEmpty()){
                System.out.println("count : " + count + " | line : " + line.peek() + " | stack : 비엇음 ");
            }else if (line.isEmpty() && !stack.isEmpty()){
                System.out.println("count : " + count + " | line : 비었음" + " | stack : " + stack.peek());
            }

            if (!stack.isEmpty() && stack.peek() == count) {
                stack.pop();
                count++;
            }else if (!line.isEmpty() && line.peek() == count) {
                line.pop();
                count++;
            }else if(!line.isEmpty() && line.peek() != count) {
                stack.push(line.pop());
            }else {
                result = "Sad";
                break;
            }
        }
        System.out.println(result);
    }
}
