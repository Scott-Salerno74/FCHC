import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board goal = new Board(3, 3); //goal board
        goal.fillBoard("1", "2", "3",
                "4", "5", "6",
                "7", "8", "");
        Board initial = new Board(3,3); //starting board
        initial.fillBoard("1", "2", "3",
                "4", "5", "6",
                "7", "8", "");
        initial.shufflePuzzle();// we shuffle the board to get a random starting position
        initial.printBoard();
        System.out.println("Pause");
        puzzle eightPuzzle = new puzzle(initial,goal);
        boolean solve = eightPuzzle.isSolvable();
        Scanner scannie = new Scanner(System.in);
        String block = scannie.next();
        PuzzleAction act = new PuzzleAction(block);
        eightPuzzle.start.performMove(act);

        eightPuzzle.start.printBoard();

        System.out.println("Is the puzzle solvable? "+ solve );
        //
    }
}
