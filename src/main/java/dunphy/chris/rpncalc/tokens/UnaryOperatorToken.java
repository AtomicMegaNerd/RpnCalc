package dunphy.chris.rpncalc.tokens;

import dunphy.chris.rpncalc.tokens.operations.UnaryOperation;

public class UnaryOperatorToken implements Token {
	protected UnaryOperation unaryOperation;

	public UnaryOperatorToken(UnaryOperation unaryOperation) {
		this.unaryOperation = unaryOperation;
	}

	public UnaryOperation getUnaryOperation() {
		return unaryOperation;
	}
}
