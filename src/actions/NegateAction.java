package actions;
import machine.InterimResult;
/**
 * @author Adam Pine
 *
 */
public class NegateAction implements Action {
	/**
	 * The action that happens when we are in start state, and get a '-' character.
	 */
	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		ir.setS(-1);
		return ir;
	}

}
