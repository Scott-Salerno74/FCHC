import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class puzzle {
    Board start; //starting position
    Board end;// end position, if we're able to get there

    public puzzle(Board i, Board g){
        start = i;
        end = g;
    }
    public boolean isSolvable(){
        int manDist = start.manhattenDistance(end);
        int shuffles = start.numOfSwaps();
        int m = manDist%2;
        int s = shuffles%2;
        if (m==s){
            return true;
        }else {
            return false;
        }
    }

//states, legal actions
    //adjact to blanck tile
    //acion will swap ; legal move for two x y pairs of blocks
}
