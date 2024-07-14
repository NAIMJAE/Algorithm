package DataStructures.Beak22866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
/*
 * 백준 22866번 - 탑 보기
 * https://www.acmicpc.net/problem/22866
 * 
 * <접근 방법>
 * - stack 2개를 만들어서 while문을 통해 현재 위치에서 왼쪽과 오른쪽에 보이는 탑들을 저장
 * - 저장할때 제일 먼저 보이는 탑은 따로 변수를 통해 저장해 두고 왼쪽과 오른쪽의 먼저 보인 탑 중 작은 값 구하고
 * - 두 stack의 크기를 더해 현재 위치에서 보이는 탑의 개수를 구함 -> 시간 초과
 * - 시간 초과 했지만 코드 자체는 정상 동작 (두번의 while문이 비효율적인듯)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] tower = new int[N];
        for (int i=0 ; i<N ; i++) {
            tower[i] = Integer.parseInt(input[i]);
        }

        String[] result = new String[N];
        for (int i=0 ; i<N ; i++) {
            Stack<Integer> left = new Stack<>();
            Stack<Integer> right = new Stack<>();
            System.out.println("i : " + i + " | left : " + left + " | right : " + right);
            
            int S = i-1;
            int T = 0;
            left.push(tower[i]);
            while (S >= 0) {
                if (left.peek() < tower[S] && T==0) {
                    left.push(tower[S]);
                    T=S;
                }else if(left.peek() < tower[S]) {
                    left.push(tower[S]);
                }
                S--;
            }

            int L = i+1;
            int M = 0;
            right.push(tower[i]);
            while (L < N) {
                if (right.peek() < tower[L] && M==0) {
                    right.push(tower[L]);
                    M=L;
                }else if (right.peek() < tower[L]) {
                    right.push(tower[L]);
                }
                L++;
            }

            System.out.println("left : " + left + " | right : " + right);

            if (left.size()==1 && right.size()==1) {
                result[i] = "0";
            }else {
                int min = 0;
                if (T==0 || M==0) {
                    min = T+M+1;
                }else {
                    min = Math.min(T, M)+1;
                }
                result[i] =  String.valueOf(left.size()+right.size()-2)+ " " + String.valueOf(min);
            }

            System.out.println(Arrays.toString(result));
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }

        for (int i=0 ; i<N ; i++) {
            System.out.println(result[i]);
        }
    }
}
