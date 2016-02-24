package inputVerifiers;
/**
 * @author Adam Pine
 *
 */
public class DigitInputVerifier implements InputVerifier {
	/**
	 * Checks if the input character is a digit.
	 */
	@Override
	public boolean meetsCriteria(char c) {
		return Character.isDigit(c);
	}

}
