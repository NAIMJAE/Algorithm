package part01.A_string.beak13223;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalTime now = LocalTime.parse(sc.nextLine());
        LocalTime trg = LocalTime.parse(sc.nextLine());

        if (now.equals(trg)) {
            System.out.println("24:00:00");
        } else {
            Duration duration = Duration.between(now, trg);
            if (duration.isNegative()) { // 음수 판별
                duration = duration.plusHours(24);
            }
            long h = duration.toHours();
            long m = duration.toMinutesPart();
            long s = duration.toSecondsPart();
            System.out.printf("%02d:%02d:%02d\n", h, m, s);
        }
    }
}
