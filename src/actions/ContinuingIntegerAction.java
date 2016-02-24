package actions;

import machine.InterimResult;

public class ContinuingIntegerAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		ir.setV(10 * ir.getV() + (c - '0'));
		return ir;
	}
}