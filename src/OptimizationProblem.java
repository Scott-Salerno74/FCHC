import java.util.List;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): page 66.<br>
 * <br>
 * A Local Search Optimization problem can be defined formally by five components: <br>
 * <ul>
 * <li>The <b>initial state</b> that the agent starts in.</li>
 * <li>A description of the possible <b>actions</b> available to the agent.
 * Given a particular state s, getActions(s) returns the set of actions that can be
 * executed in s.</li>
 * <li>A description of what each action does; the formal name for this is the
 * <b>transition model, specified by a function getResult(s, a) that returns the
 * state that results from doing action a in state s.</b></li>
 * <li>The <b>goal test</b>, which determines whether a given state is a goal
 * state.</li>
 * <li>An <b>objective function</b> of states (nodes) that is to be maximized.</li>
 * </ul>
 *
 * @author Ruediger Lunde
 * @author Mike Stampone
 */
public interface OptimizationProblem<S, A> {

    /**
     * Returns the initial state of the agent.
     */
    S getInitialState();

    /**
     * Returns the set of actions that can be executed in the given state.
     * We say that each of these actions is <b>applicable</b> in the state.
     */
    List<A> getActions(S state);

    /**
     * Returns the description of what each action does.
	 * Huh? No. Returns the state that results in given state when agent perform given action. -Fry
     */
    S getResult(S state, A action);

    /**
     * Determines whether a given state is a goal state.
     */
    boolean testGoal(S state);

    /**
     * Returns the <b>step cost</b> of taking action <code>action</code> in state <code>state</code> to reach state
     * <code>stateDelta</code> denoted by c(s, a, s').
	 * Not usually needed for Local Search optimization
	 * so commented out.
    // double getStepCosts(S state, A action, S stateDelta);
	
	/**
	 * Returns the Objective function (to be maximized) at the given state,
	 *   which could be a utility function or an evaluation function.
	 *   Added for Local Search optimization problems.
	 *  If you want to minimize a function called v(),
	 *    return -v(), or C - v() for some constant, or e^(-v) or something.
	 */
	double getObjective(S State); 
}
