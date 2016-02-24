package actions;
import machine.InterimResult;

/**
 * @author Adam Pine
 *
 */
public class ValueIsDigitAction implements Action {
	/**
	 * The action that happens when we get a digit while in the start state.
	 */
	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		ir.setV(c - '0');
		return ir;
	}

}
