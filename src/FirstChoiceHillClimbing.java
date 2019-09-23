import org.w3c.dom.Node;

import java.util.ArrayList;

public class FirstChoiceHillClimbing {
    public FirstChoiceHillClimbing(State initialState, Heuristic problemHeruistic) {
        Node current = new Node(initialState, -1, problemHeruistic);
        Node neighbor;
        ArrayList temp;
        ArrayList output = new ArrayList<>();
        while (true) {
            temp = getSuccessors(current.state);
            neighbor = .getBestNeighbor(problem.game.getSuccessors(current.state));
            neighbor = new Node((char[][]) neighborTemp.get(0), (int) neighborTemp.get(1), (int) neighborTemp.get(3));
            for (int i = 0; i < temp.size(); i++) {
                ArrayList stateTemp = moveOneStep(successorTemp, i);
                if ((int) stateTemp.get(3) < current.value) {
                    neighbor = new Node((char[][]) stateTemp.get(0), (int) stateTemp.get(1), (int) stateTemp.get(3));
                    break;
                }
                current = neighbor;
                cost++;
            }
        }
    }
}