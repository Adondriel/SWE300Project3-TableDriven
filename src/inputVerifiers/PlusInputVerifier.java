package inputVerifiers;

public class PlusInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c) {
		// return boolean of an == statement.
		return (c == '+');
	}

}
