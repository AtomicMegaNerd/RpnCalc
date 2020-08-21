package dunphy.chris.rpncalc.tokens;

import dunphy.chris.rpncalc.exceptions.InvalidTokenException;

public class TokenFactory {
    public static Token buildToken(String value) throws InvalidTokenException {

        /*
         * First is this a number?
         */
        try {
            double num = Double.parseDouble(value);
            return new ValueToken(num);
        } catch (NumberFormatException e) {
            // Otherwise keep going
        }

        switch (value) {

            // Some constants
            case "e":
                return new ValueToken(Math.E);
            case "pi":
                return new ValueToken(Math.PI);

            // Some unary operators
            case "sqrt":
                return new UnaryOperatorToken(Math::sqrt);
            case "sin":
                return new UnaryOperatorToken(Math::sin);
            case "cos":
                return new UnaryOperatorToken(Math::cos);
            case "tan":
                return new UnaryOperatorToken(Math::tan);
            case "neg":
                return new UnaryOperatorToken(op1 -> -op1);
            case "log":
                return new UnaryOperatorToken(Math::log);
            case "abs":
                return new UnaryOperatorToken(Math::abs);

            // Some binary operators
            case "+":
                return new BinaryOperatorToken(Double::sum);
            case "-":
                return new BinaryOperatorToken((op1, op2) -> op1 - op2);
            case "*":
                return new BinaryOperatorToken((op1, op2) -> op1 * op2);
            case "/":
                return new BinaryOperatorToken((op1, op2) -> op1 / op2);
            case "%":
                return new BinaryOperatorToken((op1, op2) -> op1 % op2);
            case "^":
                return new BinaryOperatorToken(Math::pow);
            default:
                throw new InvalidTokenException(value + " is not a valid token");
        }

    }
}
