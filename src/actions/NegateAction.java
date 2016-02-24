package actions;
import machine.InterimResult;

public class NegateAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		ir.setS(-1);
		return ir;
	}

}
