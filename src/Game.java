import java.io.IOException;
import java.util.Scanner;
public class Game {
    static int columnOne, columnTwo, columnThree, columnFour, columnFive, columnSix, columnSeven, positionGrid, value;
    static boolean firstPlayer, secondPlayer, winnerGame;
    public static void input(int grid[][]) throws IOException {
        while ((columnOne >= 0 || columnTwo >= 0 || columnThree >= 0 || columnFour >= 0 || columnFive >= 0 || columnSix >= 0 || columnSeven >= 0) && (winnerGame)) {
            if (firstPlayer) System.out.print("==> 1° Player :: ");
            else System.out.print("==> 2° Player :: ");
            System.out.flush();
            positionGrid =System.in.read()-'0';
            System.in.skip(2);
            positionGrid = positionGrid - 1;
            switch(positionGrid) {
                case 0:
                    if (columnOne >= 0) {
                        round();
                        grid[columnOne][positionGrid] = value;
                        CheckWin(grid, columnOne, positionGrid);
                        print(grid);
                        columnOne = columnOne - 1;
                    }
                    else System.out.println("Posizione Non Consentita");
                    break;
                case 1:
                    if (columnTwo >= 0) {
                        round();
                        grid[columnTwo][positionGrid] = value;
                        CheckWin(grid, columnTwo, positionGrid);
                        print(grid);
                        columnTwo = columnTwo - 1;
                    }
                    else System.out.println("Posizione Non Consentita");
                    break;
                case 2:
                    if (columnThree >= 0) {
                        round();
                        grid[columnThree][positionGrid] = value;
                        CheckWin(grid, columnThree, positionGrid);
                        print(grid);
                        columnThree = columnThree - 1;
                    }
                    else System.out.println("Posizione Non Consentita");
                    break;
                case 3:
                    if (columnFour >= 0) {
                        round();
                        grid[columnFour][positionGrid] = value;
                        CheckWin(grid, columnFour, positionGrid);
                        print(grid);
                        columnFour = columnFour - 1;
                    }
                    else System.out.println("Posizione Non Consentita");
                    break;
                case 4:
                    if (columnFive >= 0) {
                        round();
                        grid[columnFive][positionGrid] = value;
                        CheckWin(grid, columnFive, positionGrid);
                        print(grid);
                        columnFive = columnFive - 1;
                    }
                    else System.out.println("Posizione Non Consentita");
                    break;
                case 5:
                    if (columnSix >= 0) {
                        round();
                        grid[columnSix][positionGrid] = value;
                        CheckWin(grid, columnSix, positionGrid);
                        print(grid);
                        columnSix = columnSix - 1;
                    }
                    else System.out.println("Posizione Non Consentita");
                    break;
                case 6:
                    if (columnSeven >= 0) {
                        round();
                        grid[columnSeven][positionGrid] = value;
                        CheckWin(grid, columnSeven, positionGrid);
                        print(grid);
                        columnSeven = columnSeven - 1;
                    }
                    else System.out.println("Posizione Non Consentita");
                    break;
                default: System.out.println("Numero Errato");
            }
        }
    }

    private static void CheckWin(int array[][], int y, int x) {
        int sign;
        System.out.println(x);
        if (x < 4) { //verso sx
            for (int i = 0; i < 4; i++) {
                sign = array[y][i];
                if (sign == array[y][i+1] && sign == array[y][i+2] && sign == array[y][i+3]) {
                    winner(sign);
                    if (!winnerGame) System.out.println("orizzontale da sx verso dx");
                    break;
                }
            }
        }
        else {
            for (int i = 6; i > 3; i--) {
                sign = array[y][i];
                if (sign == array[y][i-1] && sign == array[y][i-2] && sign == array[y][i-3]) {
                    winner(sign);
                    if (!winnerGame) System.out.println("orizzontale da dx verso sx");
                    break;
                }
            }
        }
        if (y <= 2 && winnerGame) {
            sign = array[y][x];
            if (sign == array[y+1][x] && sign == array[y+2][x] && sign == array[y+3][x]) {
                winner(sign);
                if (!winnerGame) System.out.println("verticale");
            }
        }
        for (int j = 0; j < 6; j++) {
            if(!winnerGame) break;
            for (int i = 0; i < 7; i++) {
                sign = array[j][i];
                if (sign != 0) {
                    if (j > 2 && i <= 3) { //basso sx
                        if (sign == array[j-1][i+1] && sign == array[j-2][i+2] && sign == array[j-3][i+3]) {
                            winner(sign);
                            if (!winnerGame) break;
                        }
                    }
                    else if (j <= 2 && i <= 3) { //alto sx
                        if (sign == array[j+1][i+1] && sign == array[j+2][i+2] && sign == array[j+3][i+3]) {
                            winner(sign);
                            if (!winnerGame) break;
                        }
                    }
                    else if (j <= 2 && i >= 3) { //alto dx
                        if (sign == array[j+1][i-1] && sign==array[j+2][i-2] && sign==array[j+3][i-3]) {
                            winner(sign);
                            if (!winnerGame) break;
                        }
                    }
                    else if (j > 2 && i >= 3) { //basso dx
                        if (sign == array[j-1][i-1] && sign==array[j-2][i-2] && sign==array[j-3][i-3]) {
                            winner(sign);
                            if (!winnerGame) break;
                        }
                    }
                }
            }
        }


    }
    private static void winner(int player){
        if (player == 1){
            System.out.println("Giocatore 1 Vince");
            winnerGame = false;
        }
        else if (player == 2){
            System.out.println("Giocatore 2 Vince");
            winnerGame = false;
        }
    }
    private static void round(){
        if (firstPlayer){
            firstPlayer = false;
            secondPlayer = true;
            value = 1;
        }
        else {
            firstPlayer = true;
            secondPlayer = false;
            value = 2;
        }
    }
    public static void load(int array[][]) throws IOException{
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("INSERISCI"+i+j+": ");
                Scanner in = new Scanner(System.in);
                array[i][j]=in.nextInt();
            }
        }
    }
    private static void print(int array[][]){
        System.out.println();
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++) System.out.print("| " + array[i][j] + " |");
            System.out.println();
        }
    }
}