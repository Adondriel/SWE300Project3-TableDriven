package inputVerifiers;

public class MinusInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c) {
		return (c=='-');
	}

}
