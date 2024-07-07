package Beak1911;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * 백준 1911번 - 흙길 보수하기
 * https://www.acmicpc.net/problem/1911
 * 
 * - 작은 웅덩이일때 발판 길이가 넘어가서 다음걸 덮어줄 수 있는 경우를 생각 안해서 한 번 틀림
 * - 하나의 발판이 여러 웅덩이를 한 번에 덮을 수 있는 경우를 생각 안해서 또 틀림
 * - (끝위치 - 시작위치) 를 발판 길이로 나누어서 나머지를 이용하면 발판 남는 부분을 처리하기 힘들어 다른 방법 사용
 * - (시작위치 + 발판길이) 를 반복해서 끝위치 보다 커질때까지 반복
 */
class Puddle implements Comparable<Puddle> {
    int start;
    int end;

    public Puddle(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // Comparable 인터페이스를 구현해서 사용 가능한 메서드
    // Collections.sort()를 호출하면 TimSort 알고리즘을 사용해 List안의 요소들을 정렬시킴
    @Override
    public int compareTo(Puddle other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫줄 입력 : ");
        String input = sc.nextLine();
        int num = Integer.parseInt(input.split(" ")[0]);
        int length = Integer.parseInt(input.split(" ")[1]);

        List<Puddle> puddles = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String hole = sc.nextLine();
            int start = Integer.parseInt(hole.split(" ")[0]);
            int end = Integer.parseInt(hole.split(" ")[1]);
            puddles.add(new Puddle(start, end));
        }

        Collections.sort(puddles);

        System.out.println("puddles : " + puddles.toString());

        int count = 0;
        int current = 0;
        for (Puddle puddle : puddles) {
            int start = puddle.start;
            int end = puddle.end;

            if (current < start) {
                current = start;
            }

            while (current < end) {
                current += length;
                count++;
            }
            System.out.println("start : " + start + " | end : " + end + " | current : " + current + " | count : " + count);
        }
        sc.close();
        System.out.println(count);
    }
}
