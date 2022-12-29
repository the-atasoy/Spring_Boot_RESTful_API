package MineSweeper;

import java.util.Scanner;

public class MineSweeper {

    int row;
    int column;
    String[][] board;
    String[][] mine;

    MineSweeper(int row, int column){
        this.row = row;
        this.column = column;
    }

    public String[][] board(int row, int column){

        this.board = board;

        String[][] board = new String[row][column];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = "-";
            }
        }
        return board;
    }

    public String[][] mine(int row, int column){

        this.mine = mine;

        int mineAmount = (row * column) / 4;

        String[][] mine = new String[row][column];

        for (int i = 0; i < mine.length; i++){
            for (int j = 0; j < mine[i].length; j++){
                mine[i][j] = "-";
            }
        }

        for (int i = 0; i < mineAmount; i++){
            int a = (int)(Math.random()*row);
            int b = (int)(Math.random()*column);

            while (mine[a][b].equals("*")){
                a = (int)(Math.random()*row);
                b = (int)(Math.random()*column);
            }
            mine[a][b] = "*";
        }
        return mine;
    }

    public void run(){



        Scanner input = new Scanner(System.in);

        String[][] newBoard = this.board(this.row, this.column);
        String[][] newMine = this.mine(this.row, this.column);

        /*

        System.out.println("\n\n GAME MAP");
        for (int i = 0; i < newMine.length; i++){
            for (int j = 0; j < newMine[i].length; j++){
                System.out.print(newMine[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n");

         */




        System.out.println("===== Mine Sweeper =====");

        for (int i = 0; i < newBoard.length; i++){
            for (int j = 0; j < newBoard[i].length; j++){
                System.out.print(newBoard[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Enter row: ");
        int mineRow = input.nextInt() - 1;
        while(!(mineRow >= 0 && mineRow < this.row)){
            System.out.println("You entered an invalid value, please enter value in interval [1, " + (this.row) + "]." );
            mineRow = input.nextInt() - 1;
        }
        System.out.print("Enter Column: ");
        int mineColumn = input.nextInt() - 1;
        while(!(mineColumn >= 0 && mineColumn < this.column)){
            System.out.println("You entered an invalid value, please enter value in interval [1, " + (this.column) + "]." );
            mineColumn = input.nextInt() - 1;
        }

        // these lines for win check
        int winControl = this.column * this.row;
        int winControl2 = this.column * this.row / 4;
        while (true){

            if (newMine[mineRow][mineColumn].equals("*")){
                System.out.println("\n====== GAME OVER ======");
                System.out.println("\n====== GAME MAP ======");
                for (int i = 0; i < newMine.length; i++){
                    for (int j = 0; j < newMine[i].length; j++){
                        System.out.print(newMine[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            }

            else if (mineRow == 0 && mineColumn == 0){
                int i = 0;
                if (newMine[mineRow][mineColumn+1].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn+1].equals("*")) {
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }

            else if (mineRow == 0 && mineColumn == this.column-1){
                int i = 0;
                if (newMine[mineRow][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn-1].equals("*")) {
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }

            else if (mineRow == this.row-1 && mineColumn == 0){
                int i = 0;
                if (newMine[mineRow-1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn+1].equals("*")){
                    i++;
                }
                if (newMine[mineRow-1][mineColumn+1].equals("*")) {
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }

            else if (mineRow == this.row-1 && mineColumn == this.column-1){
                int i = 0;
                if (newMine[mineRow-1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow-1][mineColumn-1].equals("*")) {
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }

            else if (mineRow == 0 && (mineColumn != 0 || mineColumn != this.column-1)){
                int i = 0;
                if (newMine[mineRow+1][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn+1].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn+1].equals("*")){
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }

            else if (mineRow == this.row-1 && (mineColumn != this.column-1 || mineColumn != 0)){
                int i = 0;
                if (newMine[mineRow-1][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow-1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow-1][mineColumn+1].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn+1].equals("*")){
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }

            else if (mineColumn == 0 && (mineRow != this.row-1 || mineRow != 0)){
                int i = 0;
                if (newMine[mineRow-1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow-1][mineColumn+1].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn+1].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn+1].equals("*")){
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }

            else if (mineColumn == this.column-1 && (mineRow != this.row-1 || mineRow != 0)){
                int i = 0;
                if (newMine[mineRow-1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow-1][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn-1].equals("*")){
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }
            else if ((mineColumn != this.column-1 || mineColumn != 0) && (mineRow != this.row-1 || mineRow != 0)){
                int i = 0;
                if (newMine[mineRow-1][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow-1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow-1][mineColumn+1].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow][mineColumn+1].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn-1].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn].equals("*")){
                    i++;
                }
                if (newMine[mineRow+1][mineColumn+1].equals("*")){
                    i++;
                }
                newBoard[mineRow][mineColumn] = String.valueOf(i);
            }

            for (int i = 0; i < newBoard.length; i++){
                for (int j = 0; j < newBoard[i].length; j++){
                    System.out.print(newBoard[i][j] + " ");
                }
                System.out.println();
            }

            // win check
            if (!(newBoard[mineRow][mineColumn].equals("-"))){
                winControl--;
                if (winControl == winControl2){
                    System.out.println("\n======= YOU WON ========");
                    System.out.println("\n====== GAME MAP ======");
                    for (int i = 0; i < newMine.length; i++){
                        for (int j = 0; j < newMine[i].length; j++){
                            System.out.print(newMine[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }

            System.out.println("==========");
            System.out.print("Enter row: ");
            mineRow = input.nextInt() - 1;
            while(!(mineRow >= 0 && mineRow < this.row)){
                System.out.println("You entered an invalid value, please enter value in interval [1, " + (this.row) + "]." );
                mineRow = input.nextInt() - 1;
            }
            System.out.print("Enter Column: ");
            mineColumn = input.nextInt() - 1;
            while(!(mineColumn >= 0 && mineColumn < this.column)){
                System.out.println("You entered an invalid value, please enter value in interval [1, " + (this.column) + "]." );
                mineColumn = input.nextInt() - 1;
            }
        }

    }
}

