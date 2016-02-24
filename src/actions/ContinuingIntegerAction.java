package actions;

import machine.InterimResult;
/**
 * @author Adam Pine
 */
public class ContinuingIntegerAction implements Action {
	/**
	 * The action that happens when we are in integer state, and get another digit.
	 */
	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		ir.setV(10 * ir.getV() + (c - '0'));
		return ir;
	}
}