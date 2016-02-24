package inputVerifiers;

public class PeriodInputVerifier implements InputVerifier {

	@Override
	public boolean meetsCriteria(char c) {
		return (c=='.');
	}

}
