import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    String[][] board; //our board
    int blankRow; //this way we can easily know where the blank tile is
    int blankCol; // without having to keep looking for it in every method

    /*This constructor just determines rows
    and columns so the 2D array can be built
     */
    public Board(int row, int col){
        board = new String[row][col]; //can change constructor bc row = col in these cases
    }
    public void fillBoard(String r0c0, String r0c1, String r0c2,
                                String r1c0, String r1c1, String r1c2,
                                String r2c0, String r2c1, String r2c2){
        board[0][0] = r0c0;
        if(r0c0.equals("")){
            blankRow = 0;
            blankCol = 0;
        }
        board[0][1] = r0c1;
        if(r0c1.equals("")){
            blankRow = 0;
            blankCol = 1;
        }
        board[0][2] = r0c2;
        if(r0c2.equals("")){
            blankRow = 0;
            blankCol = 2;
        }
        board[1][0] = r1c0;
        if(r1c0.equals("")){
            blankRow = 1;
            blankCol = 0;
        }
        board[1][1] = r1c1;
        if(r1c1.equals("")){
            blankRow = 1;
            blankCol = 1;
        }
        board[1][2] = r1c2;
        if(r1c2.equals("")){
            blankRow = 1;
            blankCol = 2;
        }
        board[2][0] = r2c0;
        if(r2c0.equals("")){
            blankRow = 2;
            blankCol = 0;
        }
        board[2][1] = r2c1;
        if(r2c1.equals("")){
            blankRow = 2;
            blankCol = 1;
        }
        board[2][2] = r2c2;
        if(r2c2.equals("")){
            blankRow = 2;
            blankCol = 2;
        }
    }
    public void shufflePuzzle(){
        //take the board and get random
        //holds the blocks
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            numbers.add((i)); //add the numbers in
        }
        Collections.shuffle(numbers); //does the shuffle
        //now we count swaps we made
        int z = 0;
        for(int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (numbers.get(z) == 0){
                    board[x][y] = "";
                    blankRow = x;
                    blankCol = y;
                    z++;
                }
                else {
                    board[x][y] = String.valueOf(numbers.get(z));//puts it in the board
                    z++;
                }
            }
        }

    }
    public int numOfSwaps(){
        List<Integer> numbers = new ArrayList<>();
        for (int x= 0; x< board.length; x++){
            for (int y=0; y< board.length; y++){
                if (board[x][y].equals("")){
                    numbers.add(0);
                }else {
                    int num = Integer.parseInt(board[x][y]);
                    numbers.add(num);
                }
            }
        }
        int inverseCount = 0;
        for (int i = 0; i< numbers.size(); i++){
            int low = numbers.get(i);
            for (int j = i +1; j< numbers.size(); j++){
                int high = numbers.get(j);
                if ((high > low)){
                    inverseCount++;
                }
            }
        }

        return inverseCount;
    }
    public int manhattenDistance(Board end){
        //need to compute manhattan distance
        Board goal = end;
        int manhattanDis = 0;
        for(int i =0; i< goal.board.length; i++){
            for (int j=0; j< goal.board.length; j++) {
                String goalPos = goal.board[i][j]; //goal position of value
                //now we check shuffled
                if (!goalPos.equals("")) {
                    for (int x = 0; x < board.length; x++) {
                        for (int y = 0; y < board.length; y++) {
                            String curr = board[x][y]; //current position
                            if (curr.equals(goalPos)) {
                                //take the abs distace of row and column
                                manhattanDis = manhattanDis + ((Math.abs((i - x))) + (Math.abs((j - y))));
                            }
                        }
                    }
                }
            }
        }

        return manhattanDis;
    }
    public boolean isValid(PuzzleAction move) {
        //can only be valid if the blank is next to
        // desired tile to be moved
        String tile = move.getOtherTile();
        //we need to check surronding
        String up = null;
        String down = null;
        String left = null;
        String right = null;
        if (blankRow != 0) {//find the block above the tile, if possible
            up = board[blankRow - 1][blankCol];
        }
        if (blankRow != 2) {//find the block below if possible
            down = board[blankRow + 1][blankCol];
        }
        if (blankCol != 0) { //find the block to the left of the blank if possible
            left = board[blankRow][blankCol - 1];
        }

        if (blankCol != 2) {//find block to right if possible
            right = board[blankRow][blankCol + 1];
        }
        if (tile.equals(up) || tile.equals(down) || tile.equals(left) || tile.equals(right)) {
            return true;

        } else {
            return false;
        }
    }
    public void performMove(PuzzleAction a) {
        if (!isValid(a)) {
            //do nothing since can't perform move
        } else { //move is valid we need to swap the blank with given tile
            String tile = a.getOtherTile(); //this is tile we are swaping
            String checkTile = null;
            if (blankRow != 0) {//check if our swap is with tile above
                checkTile = getBlock(blankRow - 1, blankCol);
                if (checkTile.equals(tile)) { //if it is tile above, need to swap
                    int bR = getBlankRow();
                    int bC = getBlankCol();
                    board[bR][bC] = tile;
                    board[bR - 1][bC] = "";
                    blankRow = blankRow - 1;
                }
            } else if (blankRow != 2) { //check if our swap is with the tile below
                checkTile = getBlock(blankRow + 1 , blankCol);
                if (checkTile.equals(tile)){ //if it is tile above, need to swap
                    int bR = getBlankRow();
                    int bC = getBlankCol();
                    board[bR][bC] = tile;
                    board[bR + 1][bC] = "";
                    blankRow = blankRow + 1;
                }
            }
            else if(blankCol != 0){
                checkTile = getBlock(blankRow, blankCol-1);
                if (checkTile.equals(tile)) { //if it is tile to the left, need to swap
                    int bR = getBlankRow();
                    int bC = getBlankCol();
                    board[bR][bC] = tile;
                    board[bR][bC - 1] = "";
                    blankCol = blankCol - 1;
                }
            }
            else { //tile is to the righ
                checkTile = getBlock(blankRow, blankCol +1);
                if (checkTile.equals(tile)){
                    int bR = getBlankRow();
                    int bC = getBlankCol();
                    board[bR][bC] = tile;
                    board[bR][bC + 1] = "";
                    blankCol = blankCol + 1;

                }
            }
        }
    }
    public String getBlock(int row, int col){
        return board[row][col];
    }
    public int getBlankRow(){
        return blankRow;
    }
    public int getBlankCol(){
        return blankCol;
    }
    //this will print out the board
    public void printBoard(){
        for (int x=0; x< 3; x++){
            for (int y=0; y<3; y++){
                System.out.print("[" + board[x][y]+ "]");
            }
            System.out.println();
        }
    }
}


