package actions;
import machine.InterimResult;

public class ContinuingFractionAction implements Action {

	@Override
	public InterimResult execute(InterimResult x, char c) {
		InterimResult ir = new InterimResult(x);
		double v = ir.getV();
		v += ir.getP() * (c-'0');
		ir.setV(v);
		double p = ir.getP();
		p /= 10;
		ir.setP(p);
		return ir;
	}

}
