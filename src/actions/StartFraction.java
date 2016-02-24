package actions;

import machine.InterimResult;

public class StartFraction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		ir.setP(0.1);
		return ir;
	}
}