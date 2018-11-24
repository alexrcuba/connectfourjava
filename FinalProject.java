package finalproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinalProject {

    public static void main(String[] args) {
        int wincheck;
        boolean gameend = false;
        Scanner input = new Scanner(System.in);
        String[][] board = {{" ", " ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " ", " "}};
        int columncount0 = 5;
        int columncount1 = 5;
        int columncount2 = 5;
        int columncount3 = 5;
        int columncount4 = 5;
        int columncount5 = 5;
        int columncount6 = 5;
        int rowC;
        int columnC;
        String charCheck;
        while (gameend == false) {
            rowC = 0;
            while (rowC < board.length) {
                columnC = 0;
                while (columnC < board[0].length) {
                    System.out.print("|" + board[rowC][columnC]);
                    columnC++;
                }
                System.out.print("|" + "\n");
                rowC++;
            }
            int Rcolumn = 0;
            boolean redwins = false;
            boolean errorcheck;
            boolean inputcheck;
            boolean arraycheck = false;
            do {
                errorcheck = false;
                inputcheck = false;
                if (columncount0 < 0 && columncount1 < 0 && columncount2 < 0 && columncount3 < 0 && columncount4 < 0 && columncount5 < 0 && columncount6 < 0) {
                    System.out.println("Board is full and no winner can be determined. Game ends in a draw.");
                    gameend = true;
                    redwins = true;
                    break;
                }
                try {
                    do {
                        try {
                            while (errorcheck == false) {
                                System.out.print("Drop a red disk at column (0-6): ");
                                Rcolumn = input.nextInt();
                                if (Rcolumn > 6 || Rcolumn < 0) {
                                    System.out.println("Array Index Out of Bounds Exception: Column does not exist. Please only enter an integer from 0 to 6.");
                                    input.nextLine();
                                } else {
                                    errorcheck = true;
                                }
                            }
                            inputcheck = true;
                        } catch (InputMismatchException ex) {
                            System.out.println("Input Mismatch Exception: Non-integer value entered. Please only input integer values.");
                            input.nextLine();
                        }
                    } while (inputcheck == false);
                    switch (Rcolumn) {
                        case 0:
                            board[columncount0][Rcolumn] = "R";
                            columncount0--;
                            break;
                        case 1:
                            board[columncount1][Rcolumn] = "R";
                            columncount1--;
                            break;
                        case 2:
                            board[columncount2][Rcolumn] = "R";
                            columncount2--;
                            break;
                        case 3:
                            board[columncount3][Rcolumn] = "R";
                            columncount3--;
                            break;
                        case 4:
                            board[columncount4][Rcolumn] = "R";
                            columncount4--;
                            break;
                        case 5:
                            board[columncount5][Rcolumn] = "R";
                            columncount5--;
                            break;
                        case 6:
                            board[columncount6][Rcolumn] = "R";
                            columncount6--;
                            break;
                    }
                    arraycheck = true;
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Array Index Out of Bounds Exception: Chosen column is full. Please select a different column.");
                    input.nextLine();
                }
            } while (arraycheck == false);
            rowC = 0;
            while (rowC < board.length) {
                columnC = 0;
                wincheck = 1;
                while (columnC < board[0].length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Red Player Wins.");
                            redwins = true;
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                rowC++;
            }
            columnC = 0;
            while (columnC < board[0].length) {
                rowC = 0;
                wincheck = 1;
                while (rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Red Player Wins.");
                            redwins = true;
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC++;
            }
            columnC = 0;
            rowC = 0;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 1) {
                charCheck = board[rowC][columnC];
                columnC++;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 1;
            rowC = 0;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 1) {
                charCheck = board[rowC][columnC];
                columnC++;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 2;
            rowC = 0;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 2) {
                charCheck = board[rowC][columnC];
                columnC++;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 3;
            rowC = 0;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 3) {
                charCheck = board[rowC][columnC];
                columnC++;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 0;
            rowC = 1;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 1) {
                charCheck = board[rowC][columnC];
                columnC++;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 0;
            rowC = 2;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 1) {
                charCheck = board[rowC][columnC];
                columnC++;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 6;
            rowC = 0;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 1) {
                charCheck = board[rowC][columnC];
                columnC--;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 5;
            rowC = 0;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 1) {
                charCheck = board[rowC][columnC];
                columnC--;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 4;
            rowC = 0;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 2) {
                charCheck = board[rowC][columnC];
                columnC--;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 3;
            rowC = 0;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 3) {
                charCheck = board[rowC][columnC];
                columnC--;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 6;
            rowC = 1;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 1) {
                charCheck = board[rowC][columnC];
                columnC--;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            columnC = 6;
            rowC = 2;
            wincheck = 1;
            while (columnC < board[0].length && rowC < board.length - 1) {
                charCheck = board[rowC][columnC];
                columnC--;
                rowC++;
                if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                    wincheck++;
                    if (wincheck == 4) {
                        gameend = true;
                        rowC = 0;
                        columnC = 0;
                        while (rowC < board.length) {
                            columnC = 0;
                            while (columnC < board[0].length) {
                                System.out.print("|" + board[rowC][columnC]);
                                columnC++;
                            }
                            System.out.print("|" + "\n");
                            rowC++;
                        }
                        System.out.println("Red Player Wins.");
                        redwins = true;
                    }
                } else {
                    wincheck = 1;
                }
            }
            if (redwins == false) {
                rowC = 0;
                while (rowC < board.length) {
                    columnC = 0;
                    while (columnC < board[0].length) {
                        System.out.print("|" + board[rowC][columnC]);
                        columnC++;
                    }
                    System.out.print("|" + "\n");
                    rowC++;
                }
                int Ycolumn = 0;
                arraycheck = false;
                do {
                    errorcheck = false;
                    inputcheck = false;
                    try {
                        do {
                            try {
                                while (errorcheck == false) {
                                    System.out.print("Drop a yellow disk at column (0-6): ");
                                    Ycolumn = input.nextInt();
                                    if (Ycolumn > 6 || Ycolumn < 0) {
                                        System.out.println("Array Index Out of Bounds Exception: Column does not exist. Please only enter an integer from 0 to 6.");
                                        input.nextLine();
                                    } else {
                                        errorcheck = true;
                                    }
                                }
                                inputcheck = true;
                            } catch (InputMismatchException ex) {
                                System.out.println("Input Mismatch Exception: Non-integer value entered. Please only input integer values.");
                                input.nextLine();
                            }
                        } while (inputcheck == false);
                        switch (Ycolumn) {
                            case 0:
                                board[columncount0][Ycolumn] = "Y";
                                columncount0--;
                                break;
                            case 1:
                                board[columncount1][Ycolumn] = "Y";
                                columncount1--;
                                break;
                            case 2:
                                board[columncount2][Ycolumn] = "Y";
                                columncount2--;
                                break;
                            case 3:
                                board[columncount3][Ycolumn] = "Y";
                                columncount3--;
                                break;
                            case 4:
                                board[columncount4][Ycolumn] = "Y";
                                columncount4--;
                                break;
                            case 5:
                                board[columncount5][Ycolumn] = "Y";
                                columncount5--;
                                break;
                            case 6:
                                board[columncount6][Ycolumn] = "Y";
                                columncount6--;
                                break;
                        }
                        arraycheck = true;
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Array Index Out of Bounds Exception: Chosen column is full. Please select a different column.");
                        input.nextLine();
                    }
                } while (arraycheck == false);
                rowC = 0;
                while (rowC < board.length) {
                    columnC = 0;
                    wincheck = 1;
                    while (columnC < board[0].length - 1) {
                        charCheck = board[rowC][columnC];
                        columnC++;
                        if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                            wincheck++;
                            if (wincheck == 4) {
                                gameend = true;
                                rowC = 0;
                                columnC = 0;
                                while (rowC < board.length) {
                                    columnC = 0;
                                    while (columnC < board[0].length) {
                                        System.out.print("|" + board[rowC][columnC]);
                                        columnC++;
                                    }
                                    System.out.print("|" + "\n");
                                    rowC++;
                                }
                                System.out.println("Yellow Player Wins.");
                            }
                        } else {
                            wincheck = 1;
                        }
                    }
                    rowC++;
                }
                columnC = 0;
                while (columnC < board[0].length) {
                    rowC = 0;
                    wincheck = 1;
                    while (rowC < board.length - 1) {
                        charCheck = board[rowC][columnC];
                        rowC++;
                        if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                            wincheck++;
                            if (wincheck == 4) {
                                gameend = true;
                                rowC = 0;
                                columnC = 0;
                                while (rowC < board.length) {
                                    columnC = 0;
                                    while (columnC < board[0].length) {
                                        System.out.print("|" + board[rowC][columnC]);
                                        columnC++;
                                    }
                                    System.out.print("|" + "\n");
                                    rowC++;
                                }
                                System.out.println("Yellow Player Wins.");
                            }
                        } else {
                            wincheck = 1;
                        }
                    }
                    columnC++;
                }
                columnC = 0;
                rowC = 0;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC++;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 1;
                rowC = 0;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC++;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 2;
                rowC = 0;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 2) {
                    charCheck = board[rowC][columnC];
                    columnC++;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 3;
                rowC = 0;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 3) {
                    charCheck = board[rowC][columnC];
                    columnC++;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 0;
                rowC = 1;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC++;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 0;
                rowC = 2;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC++;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 6;
                rowC = 0;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC--;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 5;
                rowC = 0;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC--;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 4;
                rowC = 0;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 2) {
                    charCheck = board[rowC][columnC];
                    columnC--;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 3;
                rowC = 0;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 3) {
                    charCheck = board[rowC][columnC];
                    columnC--;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 6;
                rowC = 1;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC--;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
                columnC = 6;
                rowC = 2;
                wincheck = 1;
                while (columnC < board[0].length && rowC < board.length - 1) {
                    charCheck = board[rowC][columnC];
                    columnC--;
                    rowC++;
                    if (charCheck.equals(board[rowC][columnC]) && !" ".equals(board[rowC][columnC])) {
                        wincheck++;
                        if (wincheck == 4) {
                            gameend = true;
                            rowC = 0;
                            columnC = 0;
                            while (rowC < board.length) {
                                columnC = 0;
                                while (columnC < board[0].length) {
                                    System.out.print("|" + board[rowC][columnC]);
                                    columnC++;
                                }
                                System.out.print("|" + "\n");
                                rowC++;
                            }
                            System.out.println("Yellow Player Wins.");
                        }
                    } else {
                        wincheck = 1;
                    }
                }
            }
        }
    }
}
