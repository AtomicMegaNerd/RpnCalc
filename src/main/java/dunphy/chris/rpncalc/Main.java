package dunphy.chris.rpncalc;

import dunphy.chris.rpncalc.calculator.Registers;
import dunphy.chris.rpncalc.calculator.RpnCalculator;

import java.util.Scanner;

public class Main {
    private static final String STARS = "************************************************";
    private final Registers registers = new Registers(0, 0, 0, 0, 0);
    private final RpnCalculator rpnCalc = new RpnCalculator(registers);

    public static void main(String[] args) throws Exception {
        new Main().go();
    }

    public void go() {
        Scanner scanner = null;
        scanner = new Scanner(System.in);
        try {
            while (true) {
                String token = null;
                System.out.println("\nRPN SuperCalc 2000 JLT Limited Edition");
                System.out.println(STARS);
                System.out.println("3: " + registers.getR3());
                System.out.println("2: " + registers.getR2());
                System.out.println("1: " + registers.getR1());
                System.out.println("0: " + registers.getR0());
                System.out.println(STARS);
                System.out.print("> ");

                token = scanner.nextLine().trim().toLowerCase();

                switch (token) {
                    case "q":
                        System.out.println("Good-bye");
                        return;
                    case "c":
                        registers.clear();
                        break;
                    default:
                        try {
                            rpnCalc.parseToken(token);
                        } catch (Exception e) {
                            System.err.println("ERROR: " + e.getMessage());
                        }
                }
            }
        } finally {
            scanner.close();
        }
    }
}
