package dunphy.chris.rpncalc.calculator;

import dunphy.chris.rpncalc.exceptions.MemoryEmptyException;
import dunphy.chris.rpncalc.exceptions.MemoryFullException;

/*
 * This class implements the memory registers
 * for our calculator.  They are named r0, r1, r2, and r3.
 * We can push and pop numbers to/from the bottom
 * registers only.  We can store four numbers in
 * our calculator's memory
 */
public class Registers {

	private static final int CAPACITY = 4;

	private double r0 = 0;
	private double r1 = 0;
	private double r2 = 0;
	private double r3 = 0;
	private int size = 0;

	public Registers(double r0, double r1, double r2, double r3, int size) {
		this.r0 = r0;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.size = size;
	}

	public double getR0() {
		return r0;
	}

	public double getR1() {
		return r1;
	}

	public double getR2() {
		return r2;
	}

	public double getR3() {
		return r3;
	}

	public int size() {
		return size;
	}

	public void clear() {
		r0 = 0;
		r1 = 0;
		r2 = 0;
		r3 = 0;
		size = 0;
	}

	public double pop() throws MemoryEmptyException {
		if (size < 1)
			throw new MemoryEmptyException("Memory is empty");
		double res = r0;
		r0 = r1;
		r1 = r2;
		r2 = r3;
		r3 = 0.0;
		size--;
		return res;
	}

	public void push(double element) throws MemoryFullException {
		if (size < CAPACITY) {
			r3 = r2;
			r2 = r1;
			r1 = r0;
			r0 = element;
			size++;
		} else {
			throw new MemoryFullException("Memory is full.");
		}
	}
}
