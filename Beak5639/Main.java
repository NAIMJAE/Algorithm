package Beak5639;

import java.util.Scanner;
/*
 * 백준 5639번 - 이진 검색 트리
 * https://www.acmicpc.net/problem/5639
 * 
 * <접근 방법>
 * - 현재 입력한 숫자를 root와 비교해 left, right 구분
 * - 
 * 
 * - 일단 이해는 했는데 단편적인 이해라서 추후에 트리 공부 더 하고 다시 볼것!
 */
public class Main {
    public static class Node{
		Node left;
		Node right;
		int num;
		
		public Node(int num) {
			left = null;
			right = null;
			this.num = num;
		}
		
		public void addNode(Node newNode) {
			if(this.num > newNode.num) {
                System.out.println("왼쪽 : " + newNode.num);
				if(this.left == null) {
					this.left = newNode;
				}else {
					this.left.addNode(newNode);
				}
			}else {
                System.out.println("오른쪽 : " + newNode.num);
				if(this.right == null) {
					this.right = newNode;
				}else {
					this.right.addNode(newNode);
				}
			}
		}
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 첫 번째 입력은 루트 노드로 설정
        if (!sc.hasNextLine()) {
            sc.close();
            return;
        }
        Node root = new Node(Integer.parseInt(sc.nextLine()));

        while (sc.hasNextLine()) {
            String num = sc.nextLine();
            if (num.trim().isEmpty()) {
                break;
            }
            root.addNode(new Node(Integer.parseInt(num)));
        }
        sc.close();
        preoder(root);
    }

    // 후위 순회 결과 출력
    public static void preoder(Node N) {
		if(N == null) {
			return;
        }
		preoder(N.left);
		preoder(N.right);
		System.out.println(N.num);
	}
}
