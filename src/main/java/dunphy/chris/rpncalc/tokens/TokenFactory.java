package dunphy.chris.rpncalc.tokens;

import dunphy.chris.rpncalc.exceptions.InvalidTokenException;
import dunphy.chris.rpncalc.tokens.operations.*;

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
			return new UnaryOperatorToken(new UnaryOperation() {
				public double doOperation(double op1) {
					return Math.sqrt(op1);
				}
			});
		case "sin":
			return new UnaryOperatorToken(new UnaryOperation() {
				public double doOperation(double op1) {
					return Math.sin(op1);
				}
			});
		case "cos":
			return new UnaryOperatorToken(new UnaryOperation() {
				public double doOperation(double op1) {
					return Math.cos(op1);
				}
			});
		case "tan":
			return new UnaryOperatorToken(new UnaryOperation() {
				public double doOperation(double op1) {
					return Math.tan(op1);
				}
			});
		case "neg":
			return new UnaryOperatorToken(new UnaryOperation() {
				public double doOperation(double op1) {
					return -op1;
				}
			});
		case "log":
			return new UnaryOperatorToken(new UnaryOperation() {
				public double doOperation(double op1) {
					return Math.log(op1);
				}
			});
		case "abs":
			return new UnaryOperatorToken(new UnaryOperation() {
				public double doOperation(double op1) {
					return Math.abs(op1);
				}
			});

		// Some binary operators
		case "+":
			return new BinaryOperatorToken(new BinaryOperation() {
				public double doOperation(double op1, double op2) {
					return op1 + op2;
				}
			});
		case "-":
			return new BinaryOperatorToken(new BinaryOperation() {
				public double doOperation(double op1, double op2) {
					return op1 - op2;
				}
			});
		case "*":
			return new BinaryOperatorToken(new BinaryOperation() {
				public double doOperation(double op1, double op2) {
					return op1 * op2;
				}
			});
		case "/":
			return new BinaryOperatorToken(new BinaryOperation() {
				public double doOperation(double op1, double op2) {
					return op1 / op2;
				}
			});
		case "%":
			return new BinaryOperatorToken(new BinaryOperation() {
				public double doOperation(double op1, double op2) {
					return op1 % op2;
				}
			});
		case "^":
			return new BinaryOperatorToken(new BinaryOperation() {
				public double doOperation(double op1, double op2) {
					return Math.pow(op1, op2);
				}
			});
		default:
			throw new InvalidTokenException(value + " is not a valid token");
		}

	}
}
