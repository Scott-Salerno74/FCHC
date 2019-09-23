public class PuzzleAction {

    String blankTile = "";
    String otherTile;

    //Action takes a string
    public PuzzleAction(String tile){
        otherTile = tile;
    }

    public String getOtherTile() {
        return otherTile;
    }
}
