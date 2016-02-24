package inputVerifiers;
/**
 * @author Adam Pine
 *
 */
public class PlusInputVerifier implements InputVerifier {
	/**
	 * Checks if the input character is '+'
	 */
	@Override
	public boolean meetsCriteria(char c) {
		// return boolean of an == statement.
		return (c == '+');
	}

}
