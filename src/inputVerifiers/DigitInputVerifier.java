package inputVerifiers;
/**
 * 
 * @author Adam Pine
 *
 */
public class DigitInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c) {
		return Character.isDigit(c);
	}

}
