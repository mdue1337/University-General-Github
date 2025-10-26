/**
 * @author Martin Due & Math
 * Opgave 1 main class with args[] interpolation
 */

public class Opgave1{
    public static void main(String[] args){
        if(args.length == 0){
            throw new IllegalArgumentException();
        }

        Solver solution = new Solver();
        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            solution.findAllSolutions(i);
        }
    }
}
