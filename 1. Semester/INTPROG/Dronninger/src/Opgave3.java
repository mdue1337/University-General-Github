/**
 * @author Martin Due & Math
 * Opgave 3 main class with args[] interpolation
 */

public class Opgave3 {
    public static void main(String[] args){
        if(args.length == 0){
            throw new IllegalArgumentException();
        }

        Solver solution = new Solver();
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        solution.findNoOfSolutions(min, max);
    }
}
