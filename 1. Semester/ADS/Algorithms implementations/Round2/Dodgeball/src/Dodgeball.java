// Version: 20200917
// Handin done by:
//   AU786751 Martin Due
//   AU806016 Filip Raeburn
//   AU804976 Matthias W. Jensen
// Contributions:
//   Teoretisk snak og diskussion af opgaven udført af alle medlemmer.
//   Implementering udført af Martin Due & Filip Raeburn

import java.io.*;
import java.util.*;
public class Dodgeball {
    private TreeSet<Integer> players = new TreeSet<>();

    // Add any private fields you might need here
    public void addPlayer(int x) {
        players.add(x);
    }

    public int throwBall(int x) {
        if (players.contains(x)){
            players.remove(x);
            return 0;
        }

        Integer lower = players.lower(x);
        Integer higher = players.higher(x);

        // If both sides have players, get the minimum distance.
        if(lower != null && higher != null){
            int leftDist = x - lower;
            int rightDist = higher - x;

            if (leftDist <= rightDist) { // tie -> choose numerically smaller (lower)
                players.remove(lower);
                players.add(x);
                return leftDist;
            } else {
                players.remove(higher);
                players.add(x);
                return rightDist;
            }
        }
        // else check if there is a player on the right side.
        else if (higher != null) {
            int distance = higher - x;
            players.remove(higher);
            players.add(x);
            return distance;
        }
        // There must be a player on the left side, because we know there is at least one player.
        else {
            int distance = x - lower;
            players.remove(lower);
            players.add(x);
            return distance;
        }
    }
}