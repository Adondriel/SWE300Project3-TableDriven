package machine;
import actions.Action;

import actions.ContinuingFractionAction;
import actions.ContinuingIntegerAction;
import actions.NegateAction;
import actions.NoAction;
import actions.StartFraction;
import actions.ValueIsDigitAction;
import inputVerifiers.DigitInputVerifier;
import inputVerifiers.InputVerifier;
import inputVerifiers.MinusInputVerifier;
import inputVerifiers.PeriodInputVerifier;
import inputVerifiers.PlusInputVerifier;
import machine.InterimResult;

/**
 * A finite state machine that parses a string containing a real number. Will
 * throw NumberFormatExcaption if the string doesn't not contain a legal
 * representation of a real number. Note: we are not dealing with scientific
 * notation
 * 
 * @author Merlin
 *
 */
public class ConvertingMachine {

	private final Edge[] machine = {
			new Edge(State.START, new DigitInputVerifier(), new ValueIsDigitAction(), State.INTEGER),
			new Edge(State.START, new MinusInputVerifier(), new NegateAction(), State.INTEGER),
			new Edge(State.START, new PlusInputVerifier(), new NoAction(), State.INTEGER),
			new Edge(State.START, new PeriodInputVerifier(), new StartFraction(), State.DECIMAL),
			new Edge(State.INTEGER, new DigitInputVerifier(), new ContinuingIntegerAction(), State.INTEGER),
			new Edge(State.INTEGER, new PeriodInputVerifier(), new StartFraction(), State.DECIMAL),
			new Edge(State.DECIMAL, new DigitInputVerifier(), new ContinuingFractionAction(), State.DECIMAL)
	};

	public double parse(String text) {
		InterimResult ir = new InterimResult(0.1, 1, 0);
		State currentState = State.START;
		Edge currentEdge = null;
		for (int i=0; i<text.length();i++){
			currentEdge = searchForEdge(currentState, text.charAt(i));
			ir = currentEdge.action.execute(ir, text.charAt(i));
			currentState = currentEdge.nextState;
		}
		return ir.getS()*ir.getV();
	}

	private Edge searchForEdge(State currentState, char ch) {
		for (int i=0;i <machine.length;i++){
			if (machine[i].currentState.equals(currentState)){
				if (machine[i].inputVerifier.meetsCriteria(ch)){
					return machine[i];
				}
			}
		}
		throw new NumberFormatException();
	}

	private class Edge {
		State currentState;
		InputVerifier inputVerifier;
		Action action;
		State nextState;

		public Edge(State currentState, InputVerifier inputVerifier, Action action, State nextState) {
			this.currentState = currentState;
			this.inputVerifier = inputVerifier;
			this.action = action;
			this.nextState = nextState;
		}
	}

	private enum State {
		START, INTEGER, DECIMAL, END
	}
}
