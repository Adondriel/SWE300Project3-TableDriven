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

	/**
	 * @author Adam Pine
	 * @param text
	 * @return the double value of a string of text.
	 */
	public double parse(String text) {
		// the initial InterimResult.
		InterimResult ir = new InterimResult(0.1, 1, 0);
		// the starting state.
		State currentState = State.START;
		// Edge is null at first, because we dont have the input yet.
		Edge currentEdge = null;
		// Loop through the input text, for each character.
		for (int i = 0; i < text.length(); i++) {
			//search for the edge, for each character.
			currentEdge = searchForEdge(currentState, text.charAt(i));
			//Execute that edge's action, and set IR to the returned value.
			ir = currentEdge.action.execute(ir, text.charAt(i));
			//Set currentState to the edge's next state.
			currentState = currentEdge.nextState;
		}
		// Return the Sign * Value of the InterimResult.
		return ir.getS() * ir.getV();
	}

	/**
	 * @author Adam Pine
	 * @param currentState
	 * @param ch
	 * @return the edge that should be used.
	 */
	private Edge searchForEdge(State currentState, char ch) {
		// loop through the table.
		for (int i = 0; i < machine.length; i++) {
			// Find check if the state matches the current state.
			if (machine[i].currentState.equals(currentState)) {
				// Check if the input matches the input verifier.
				if (machine[i].inputVerifier.meetsCriteria(ch)) {
					// if so, this is our edge! return it!
					return machine[i];
				}
			}
		}
		// If it doesn't match anything from the table, you formatted it wrong,
		// throw an exeception.
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
