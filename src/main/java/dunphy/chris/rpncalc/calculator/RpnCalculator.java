package dunphy.chris.rpncalc.calculator;

import dunphy.chris.rpncalc.exceptions.InvalidOperationException;
import dunphy.chris.rpncalc.exceptions.InvalidTokenException;
import dunphy.chris.rpncalc.exceptions.MemoryEmptyException;
import dunphy.chris.rpncalc.exceptions.MemoryFullException;
import dunphy.chris.rpncalc.tokens.*;

public class RpnCalculator {

    private final Registers registers;

    public RpnCalculator(Registers registers) {
        this.registers = registers;
    }

    public void parseToken(String value) throws MemoryFullException,
            MemoryEmptyException, InvalidOperationException,
            InvalidTokenException {
        Token token = TokenFactory.buildToken(value);
        if (token instanceof ValueToken) {
            ValueToken valueToken = (ValueToken) token;
            registers.push(valueToken.getValue());
        } else if (token instanceof UnaryOperatorToken) {

            UnaryOperatorToken unaryToken = (UnaryOperatorToken) token;

            if (registers.size() < 1) {
                throw new InvalidOperationException("Not enough operands.");
            }

            double op1 = registers.pop();
            double res = unaryToken.getUnaryOperation().doOperation(op1);
            registers.push(res);
        } else if (token instanceof BinaryOperatorToken) {

            BinaryOperatorToken binaryToken = (BinaryOperatorToken) token;

            if (registers.size() < 2) {
                throw new InvalidOperationException("Not enough operands.");
            }

            double op1 = registers.pop();
            double op2 = registers.pop();
            double res = binaryToken.getBinaryOperation().doOperation(op2, op1);
            registers.push(res);
        }
    }
}
