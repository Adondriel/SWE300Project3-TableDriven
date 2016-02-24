package actions;
import machine.InterimResult;
public interface Action
{
	public InterimResult execute(InterimResult x, char c);
}