package MineSweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int row = 0;
        int column = 0;
        System.out.println("\nSELECT DIFFICULTY LEVEL\n=======================\n1 => EASY\n2 => INTERMEDIATE\n3 => HARD\n4 => INSANE");
        System.out.print(": ");
        int level = input.nextInt();

        while(!(level > 0 && level <5)){
            System.out.println("You entered an invalid value, please enter difficulty level between 1 and 4.");
            System.out.print(": ");
            level = input.nextInt();
        }

        if (level == 1){
            row = 4;
            column = 4;
        }
        else if (level == 2){
            row = 6;
            column = 6;
        }
        else if (level == 3){
            row = 8;
            column = 8;
        }
        else if (level == 4){
            row = 20;
            column = 20;
        }

        MineSweeper m1 = new MineSweeper(row,column);
        m1.run();
    }
}

