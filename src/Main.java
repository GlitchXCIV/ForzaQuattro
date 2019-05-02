import java.io.IOException;
public class Main {
    public static void main(String[] arg0) throws IOException {
        int [][] grid;
        Game.columnOne =Game.columnTwo =Game.columnThree =Game.columnFour =Game.columnFive =Game.columnSix =Game.columnSeven =5;
        Game.firstPlayer =true;
        Game.secondPlayer =false;
        Game.winnerGame =true;
        grid= new int [6][7];
        Game.input(grid);
    }
}