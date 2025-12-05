// Version: 20200917
// Handin done by:
//   202506244 Simon Glob
//   202507081 Martin Due.
//   202507120 Carl Lee Ladefoged.
// Contributions:
//   Simon Glob Theoretical and code
//   Martin Due Theoretical and code
//   Carl Lee Ladefoged Theoretical

import java.io.*;
import java.lang.invoke.CallSite;
import java.util.*;

public class MazePair {
    public int shortestPath(char[][] maze) {
        // Initialize values
        int height = maze.length;
        int width = maze[0].length;

        // We must find all 'r' positions.
        List<int[]> starts = new ArrayList<>();
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (maze[i][j] == 'r') {
                    starts.add(new int[]{i, j});
                }
            }
        }

        // Variables to store candidates and directions.
        List<Integer> candidates = new ArrayList<>();
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        // BFS foreach found 'r'
        for(int[] start : starts){

            int i = start[0], j = start[1];

            // Make a 2d array to store visited paths.
            boolean[][] visited = new boolean[height][width];

            // Create queue for BFS
            Queue<int[]> q = new LinkedList<>();
            Queue<Integer> dist = new LinkedList<>();

            // Current value has been visited, we add current value to the queue and add distance 0
            visited[i][j] = true;
            q.add(new int[]{i, j});
            dist.add(0);

            // BFS start
            while (!q.isEmpty()) {
                // DEQUEUE(u)
                int d = dist.poll();

                // Select current indices
                int[] node = q.poll();
                i = node[0];
                j = node[1];

                // Explore ALL possible directions
                for (int[] dir : directions) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    // Bounds for our maze.
                    boolean inside = newI >= 1 && newI < height - 1 &&
                            newJ >= 1 && newJ < width - 1;

                    // If we are outside bounds, continue.
                    if (!inside) continue;

                    // This is a walkable path.
                    if (maze[newI][newJ] != 'o' && !visited[newI][newJ]) {

                        // We found b, add it to the candidates
                        if (maze[newI][newJ] == 'b') {
                            candidates.add(d + 1);
                            continue;
                        }

                        // Mark visited, add the new node to BFS queue and the incremented distance.
                        visited[newI][newJ] = true;
                        q.add(new int[]{newI, newJ});
                        dist.add(d + 1);
                    }
                }
            }
        }

        // If there is a candidate, which we could assume but we do not, return the minimum or else the MAX_VALUE.
        return candidates.isEmpty() ? Integer.MAX_VALUE : Collections.min(candidates);
    }

    public static void testAll() {
        clearTerminal();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
    }

    public static void test1() {
        char[][] maze = {
            "oooooo".toCharArray(),
            "or..bo".toCharArray(),
            "or..bo".toCharArray(),
            "or..bo".toCharArray(),
            "oooooo".toCharArray(),
        };
        int correctAnswer = 3;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test1",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test1");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test1", "Exception: " + e);
        }
    }

    public static void test2() {
        char[][] maze = {
            "ooooo".toCharArray(),
            "orooo".toCharArray(),
            "ooooo".toCharArray(),
            "ooobo".toCharArray(),
            "ooooo".toCharArray(),
        };
        int correctAnswer = Integer.MAX_VALUE;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test2",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test2");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test2", "Exception: " + e);
        }
    }

    public static void test3() {
        char[][] maze = {
            "oooooooo".toCharArray(),
            "o..r...o".toCharArray(),
            "oooooo.o".toCharArray(),
            "o......o".toCharArray(),
            "o.oooooo".toCharArray(),
            "o..b...o".toCharArray(),
            "oooooooo".toCharArray(),
        };
        int correctAnswer = 14;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test3",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test3");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test3", "Exception: " + e);
        }
    }

    public static void test4() {
        char[][] maze = {
            "ooooooooo".toCharArray(),
            "o.o...o.o".toCharArray(),
            "oro.o.o.o".toCharArray(),
            "obo.o.o.o".toCharArray(),
            "o.o.o.o.o".toCharArray(),
            "o...o...o".toCharArray(),
            "ooooooooo".toCharArray(),
        };
        int correctAnswer = 1;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test4",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test4");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test4", "Exception: " + e);
        }
    }

    public static void test5() {
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "ob..o.......o".toCharArray(),
            "o.o.o.ooo.ooo".toCharArray(),
            "o.o...o...o.o".toCharArray(),
            "o.ooooooooo.o".toCharArray(),
            "o.ooo.o...o.o".toCharArray(),
            "o.o...o.o...o".toCharArray(),
            "o.o.o.o.ooo.o".toCharArray(),
            "o...o.....o.o".toCharArray(),
            "ooooo...oooro".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 28;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test5",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test5");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test5", "Exception: " + e);
        }
    }

    public static void test6() {
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "o...........o".toCharArray(),
            "ooooo.ooobo.o".toCharArray(),
            "o.....o.o...o".toCharArray(),
            "oooro.o.ooo.o".toCharArray(),
            "obo.o.r.....o".toCharArray(),
            "o.o.o.o.o.o.o".toCharArray(),
            "o.o.....o...o".toCharArray(),
            "o.o.ooo.o.o.o".toCharArray(),
            "o...o...o.o.o".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 10;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test6",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test6");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test6", "Exception: " + e);
        }
    }

    public static void test7() {
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "or..o.......o".toCharArray(),
            "ooo.o.o.ooo.o".toCharArray(),
            "o...o.o.....o".toCharArray(),
            "o.o.o.ooooo.o".toCharArray(),
            "oro.o.....obo".toCharArray(),
            "o.o.o.ooo.ooo".toCharArray(),
            "o.o...o...o.o".toCharArray(),
            "o.o.o.obo.o.o".toCharArray(),
            "o...o.o.....o".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 21;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test7",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test7");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test7", "Exception: " + e);
        }
    }

    public static void test8() {
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "or..........o".toCharArray(),
            "ooo.oo.oo.ooo".toCharArray(),
            "ooo.oo.oo.ooo".toCharArray(),
            "o...........o".toCharArray(),
            "oo.oo.oo.oo.o".toCharArray(),
            "oo.oo.oo.oo.o".toCharArray(),
            "oo.........bo".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 16;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test8",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test8");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test8", "Exception: " + e);
        }
    }

    public static void test9() {
        char[][] maze = {
            "oooooooooooooo".toCharArray(),
            "or.o.........o".toCharArray(),
            "o.o..........o".toCharArray(),
            "o..o.........o".toCharArray(),
            "o.oo...o.ooo.o".toCharArray(),
            "o.o...o.o....o".toCharArray(),
            "o.o.ooo...oooo".toCharArray(),
            "o...ooo.....bo".toCharArray(),
            "oooooooooooooo".toCharArray(),
        };
        int correctAnswer = 31;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test9",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test9");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test9", "Exception: " + e);
        }
    }

    public static void test10() {
        char[][] maze = {
            "ooooooooooooo".toCharArray(),
            "o.o.o.....obo".toCharArray(),
            "o.o.ooo.ooo.o".toCharArray(),
            "o...r...o...o".toCharArray(),
            "ooooo.o.o.ooo".toCharArray(),
            "o.....o.....o".toCharArray(),
            "o.ooooooo.o.o".toCharArray(),
            "o.ooo.oboro.o".toCharArray(),
            "o...o.ooooo.o".toCharArray(),
            "ooo.o.......o".toCharArray(),
            "o.....b.ooo.o".toCharArray(),
            "ooooooooooooo".toCharArray(),
        };
        int correctAnswer = 8;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test10",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test10");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test10", "Exception: " + e);
        }
    }

    public static void test11() {
        char[][] maze = {
            "oooooooo".toCharArray(),
            "obo....o".toCharArray(),
            "obo.o..o".toCharArray(),
            "o.o.orro".toCharArray(),
            "o.o.o..o".toCharArray(),
            "o...o..o".toCharArray(),
            "oooooooo".toCharArray(),
        };
        int correctAnswer = 13;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test11",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test11");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test11", "Exception: " + e);
        }
    }

    public static void test12() {
        char[][] maze = {
            "oooooooo".toCharArray(),
            "o..bo.oo".toCharArray(),
            "ooo.oboo".toCharArray(),
            "o.....oo".toCharArray(),
            "ooo.o.oo".toCharArray(),
            "orr....o".toCharArray(),
            "oooooooo".toCharArray(),
        };
        int correctAnswer = 5;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test12",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test12");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test12", "Exception: " + e);
        }
    }

    public static void test13() {
        char[][] maze = {
            "ooooooooooooooo".toCharArray(),
            "o.......or..o.o".toCharArray(),
            "o.ooo.o.oro.o.o".toCharArray(),
            "o...o.o...o...o".toCharArray(),
            "o.o.ooooooooo.o".toCharArray(),
            "o.ob.....bo...o".toCharArray(),
            "o.ooooooo.o.o.o".toCharArray(),
            "o.......o...o.o".toCharArray(),
            "o.o.o.o.ooo.o.o".toCharArray(),
            "o.o.o.....o...o".toCharArray(),
            "o.o.o.ooo.o.ooo".toCharArray(),
            "o.o.o.o.......o".toCharArray(),
            "ooooooooooooooo".toCharArray(),
        };
        int correctAnswer = 16;

        try {
            int output = new MazePair().shortestPath(maze);

            if (output != correctAnswer)
                outputFail("test13",
                           "Expected output " + correctAnswer +
                           " but got " + output);
            else
                outputPass("test13");
        } catch (Exception e) {
            e.printStackTrace();
            outputFail("test13", "Exception: " + e);
        }
    }

    private static void clearTerminal() {
        System.out.print('\u000C');
    }

    private static void outputPass(String testName) {
        System.out.println("[Pass " + testName + "]");
    }

    private static void outputFail(String testName, String message) {
        System.out.println("[FAIL " + testName + "] " + message);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        if (testcases == 0) testAll();
        for (int t = 0; t < testcases; ++t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] maze = new char[n][];
            for (int i = 0; i < n; ++i) {
                maze[i] = sc.next().toCharArray();
                if (maze[i].length != m) {
                    System.out.println("Wrong length of line "+(i+1)+": "+maze[i].length+" != "+m);
                    return;
                }
            }
            System.out.println(new MazePair().shortestPath(maze));
        }
    }
}
