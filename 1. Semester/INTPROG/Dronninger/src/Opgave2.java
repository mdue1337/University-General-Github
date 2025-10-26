/**
 * @author
 * Opgave 2 main class with args[] interpolation
 */

public class Opgave2 {
    public static void main(String[] args){
        if(args.length == 0){
            throw new IllegalArgumentException();
        }

        Solver solution = new Solver();
        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            long timeStart = System.currentTimeMillis();
            solution.findAllSolutions(i);
            long timeEnd = System.currentTimeMillis();
            long duration = timeEnd - timeStart;
            System.out.printf("Took %s ms to find solution\n", duration);
        }
    }
}
