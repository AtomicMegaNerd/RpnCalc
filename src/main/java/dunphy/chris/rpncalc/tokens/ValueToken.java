package dunphy.chris.rpncalc.tokens;

public class ValueToken implements Token {
    protected double value;

    public ValueToken(double num) {
        this.value = num;
    }

    public double getValue() {
        return value;
    }
}
