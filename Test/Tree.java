package Test;

public class Tree {
    public static void main(String[] args) {

        // ANSI 색상 코드
        String reset = "\u001B[0m"; // 초기화

        // Regular Colors
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String purple = "\u001B[35m";
        String cyan = "\u001B[36m";
        String white = "\u001B[37m";

        // Bold Colors
        String boldRed = "\u001B[1;31m";
        String boldGreen = "\u001B[1;32m";
        String boldBlue = "\u001B[1;34m";

        // Background Colors
        String bgRed = "\u001B[41m";
        String bgGreen = "\u001B[42m";
        String bgYellow = "\u001B[43m";


        for (int i=0; i<10; i++) {
            if (i == 0) {
                System.out.print(yellow+"          ★          "+ reset);
                continue;
            }else {
                System.out.println();
            }

            for(int n=i; n<10; n++) {
                System.out.print(" ");
            }

            int k = (i*2)+1;

            for (int j=0; j<k; j++) {
                if (j < k/2) {

                    int R = (int) (Math.random()*10);

                    if (j == R) {
                        if (R%2 == 0) {
                            System.out.print(red+"♥"+ reset);
                        }else {
                            System.out.print(yellow+"☆"+ reset);
                        }
                    }else {
                        System.out.print(green+"<"+ reset);
                    }

                }else if(j == k/2) {
                    System.out.print(green+"#"+ reset);
                }else {
                    int R = (int) (Math.random()*10);

                    if (j == R) {
                        if (R%2 == 0) {
                            System.out.print(red+"♥"+ reset);
                        }else {
                            System.out.print(yellow+"☆"+ reset);
                        }
                    }else {
                        System.out.print(green+">"+ reset);
                    }

                }
            }
        }
        System.out.println("");
        System.out.println(purple+"  ♬  ♪   "+boldBlue+"■■■"+purple+"   ♬  ♪  ");
        System.out.println(purple+" ♪  ♬  "+boldBlue+"■■■■■■■"+purple+"  ♪  ♬ "+ reset);
    }
}
