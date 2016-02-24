package inputVerifiers;
/**
 * @author Adam Pine
 *
 */
public class MinusInputVerifier implements InputVerifier {
	/**
	 * Checks if they input character is '-'.
	 */
	@Override
	public boolean meetsCriteria(char c) {
		return (c=='-');
	}

}
