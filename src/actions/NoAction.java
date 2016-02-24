package actions;

import machine.InterimResult;
/**
 * @author Adam Pine
 *
 */
public class NoAction implements Action {
	/**
	 * The action that happens when we do not need to change anything.
	 */
	@Override
	public InterimResult execute(InterimResult x, char c) {
		return x;
	}

}
