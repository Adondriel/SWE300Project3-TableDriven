package actions;

import machine.InterimResult;
/**
 * @author Adam Pine
 *
 */
public class StartFraction implements Action {
	/**
	 * The action that happens when we get a '.' character while in the Start, or integer State.
	 */
	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		ir.setP(0.1);
		return ir;
	}
}