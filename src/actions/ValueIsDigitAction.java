package actions;
import machine.InterimResult;

/**
 * @author Adam Pine
 *
 */
public class ValueIsDigitAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		ir.setV(c-'0');
		return ir;
	}

}
