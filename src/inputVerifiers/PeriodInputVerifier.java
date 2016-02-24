package inputVerifiers;
/**
 * @author Adam Pine
 *
 */
public class PeriodInputVerifier implements InputVerifier {
	/**
	 * Checks if the input character is '.'
	 */
	@Override
	public boolean meetsCriteria(char c) {
		return (c=='.');
	}

}
