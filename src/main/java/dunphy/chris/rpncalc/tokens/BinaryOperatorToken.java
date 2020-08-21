package dunphy.chris.rpncalc.tokens;

import dunphy.chris.rpncalc.tokens.operations.BinaryOperation;

public class BinaryOperatorToken implements Token {
    private final BinaryOperation binaryOperation;

    public BinaryOperatorToken(BinaryOperation op) {
        this.binaryOperation = op;
    }

    public BinaryOperation getBinaryOperation() {
        return binaryOperation;
    }
}
