package part01.A_string.beak1543;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String trg = sc.nextLine();

        String replace = str.replace(trg, "");
        int length = str.length() - replace.length();
        int count = length / trg.length();
        System.out.println(count);
    }
}
