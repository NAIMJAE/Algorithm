package part01.D_Brute_Force.beak2817;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 백준 2817번 - ALPS식 투표
 * https://www.acmicpc.net/problem/2817
 * - 문제를 제대로 이해하지 못함, 5% 이상 득표한 사람 x 득표수를 1~14로 나눈 값의 집합에서 상위 14개를 찾아야 했음
 *   하지만, 1~14 중 각 범위에서 나누었을 때 가장 높은 값이 나오는 경우를 찾게 코드를 작성
 *   "이렇게 14 * (후보 스태프의 명수) 개의 실수를 가진 점수집합을 얻을 수 있다."
 * 
 * - 전체를 배열로 관리하고 득표수 5% 미만의 사람을 걸러내기 위해 배열에 null을 넣는 방식은 안전하지 않음 (List 권장)
 * - 5% 미만의 득표자를 추려내기 위해 [ vote * 100 / X < 5] 를 사용했는데, 프로그래밍에서는 소숫점 때문에
 *   나눗셈보다는 곱셈을 활용하는게 더 안전한 방법 [ vote * 100 < X * 5 ]
 * 
 * - 지금 작성한 코드의 시간복잡도는 이름순 정렬 때문에 O(N logN) 인데,
 *   이 문제를 객체와 자료구조 없이 순수 배열과 인덱스로 풀어버리면 O(N)이 되는데,
 *   N이 최대26밖에 안되므로 거의 O(1) 수준까지 줄여버릴 수 있음
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int N = sc.nextInt();
        Person[] person = new Person[N];

        for (int i = 0; i < N; i++) {
            char name = sc.next().charAt(0);
            int vote = sc.nextInt();

            if (vote * 100 < X * 5) {
                person[i] = null;
            } else {
                person[i] = new Person(name, vote);
            }
        }

        // 점수 계산
        List<Score> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (person[i] == null) continue;
            for (int j = 1; j <= 14; j++) {
                // 어떤 사람의 점수인지 index와 계산된 점수를 저장
                scores.add(new Score(i, (double) person[i].getVote() / j));
            }
        }

        // 내림차순 정렬
        scores.sort((s1, s2) -> Double.compare(s2.val, s1.val));

        // 3칩 배분
        for (int i = 0; i < 14 && i < scores.size(); i++) {
            int personIdx = scores.get(i).idx;
            person[personIdx].plusChip();
        }

        // 이름순 정렬
        Arrays.sort(person, (p1, p2) -> {
            if (p1 == null) return 1;
            if (p2 == null) return -1;
            return Character.compare(p1.getName(), p2.getName());
        });

        for (int i = 0; i < N; i++) {
            if (person[i] == null) continue;
            System.out.println(person[i].getName() + " " + person[i].getChip());
        }
    }
}

class Score {
    int idx;
    double val;
    Score(int idx, double val) {
        this.idx = idx;
        this.val = val;
    }
}

class Person {
    char name;
    int vote;
    int chip = 0;

    public Person(char name, int vote) {
        this.name = name;
        this.vote = vote;
    }

    public char getName() { return name; }
    public int getVote() { return vote; }
    public int getChip() { return chip; }
    public void plusChip() { this.chip++; }
}