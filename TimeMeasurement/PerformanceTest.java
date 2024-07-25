package TimeMeasurement;

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
/*
 * - Stack과 ArrayDeque에서 각각 백만 번의 push와 pop 연산을 수행하는 데 걸리는 시간을 측정
 * 
 * - Stack과 ArrayDeque 자료구조는 동기화라는 차이점을 가지고 있음
 * - 이 동기화는 멀티 쓰레드 환경에서의 안정성과 동시 접근을 위해 존재하는 기능
 * - Stack는 동기화되는 클래스 ArrayDeque는 동기화되지 않는 클래스
 * 
 * - 동기화된 클래스는 멀티스레드 환경에서 안전하게 사용될 수 있도록 설계된 반면, 
 * - 동기화되지 않은 클래스는 단일 스레드 환경에서 더 나은 성능을 제공합니다.
 * 
 * - 이 동기화라는 차이점 때문에 두 자료구조의 성능에 차이
 */
public class PerformanceTest {
    public static void main(String[] args) {
        final int ITERATIONS = 1000000;

        // Stack 테스트
        Stack<Integer> stack = new Stack<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            stack.push(i);
        }
        for (int i = 0; i < ITERATIONS; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        long durationStack = endTime - startTime;
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("Stack duration: " + durationStack + " ns");

        // ArrayDeque 테스트
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            arrayDeque.push(i);
        }
        for (int i = 0; i < ITERATIONS; i++) {
            arrayDeque.pop();
        }
        endTime = System.nanoTime();
        long durationArrayDeque = endTime - startTime;
        System.out.println("ArrayDeque duration: " + durationArrayDeque + " ns");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
}
