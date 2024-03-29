package ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class GameOfLife
{

    public static int N = 5;
    public static int M = 1000;


    public int [][] board1 = new int [M][M];
    public int [][] board2 = new int [M][M];


    // used to store the best start pattern
    public int [][] bestBox = new int [N][N];

    public int [][] bestFinal = new int [M][M];
    public int [][] bestFinal2 = new int [M][M];
    public int [][] bestStart = new int [M][M];
    public int [][] bestStart2 = new int [M][M];
    public int [][] box;


    // random seed
    public long seed = System.currentTimeMillis();
    public Random rand = new Random();


    // booleans to tell which board you are on
    public boolean b1;
    public boolean b2;


    // number of desired generations
    public int generations;


    // best solution so far
    public float best;


    // number of live cells at the beginning and the end
    public float startLiveCells;
    public float endLiveCells;


    // list of the population
    public ArrayList<int [][]> population = new ArrayList<int [][]>();


    /**
     * Default constructor for the game of life
     */
    public GameOfLife()
    {
        // fill the boards with 0's
        fillBoard(board1);
        fillBoard(board2);
    }


    /**
     * Create a random start pattern
     *
     * @param box
     */
    public void randomStart(int [][] box)
    {
        for (int i = 0; i < box.length; i ++)
        {
            for (int j = 0; j < box.length; j ++)
            {
                // make the spot 0 or 1
                box[i][j] = rand.nextInt(2);
            }
        }
    }


    /**
     * Initialization: fill with 0's
     *
     * @param array
     */
    public void fillBoard(int [][] array) {
        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length; j ++) {
                array [i][j] = 0;
            }
        }
    }


    /**
     * Put the random start pattern into a larger array.
     *
     * @param array
     */
    public void setUp(int [][] array) {

        // fill the current board with 0's
        fillBoard(array);

        box = new int [N][N];

        randomStart(box);

        // put at center
        int spot = (array.length / 2) - 5;

        for (int i = spot; i < spot + N; i ++) {
            for (int j = spot; j < spot + N; j ++) {
                array[i][j] = box[i-spot][j-spot];
            }
        }
    }


    /**
     * Run Conway's Game of Life's rules
     *
     * @param iterations
     * @param array
     */
    public void run(int iterations, int [][] array)
    {
        // start on board 1
        b1 = true;
        b2 = false;

        // make board1 = passed in array
        combineArrays(array, currentBoard());

        // number of live cells to start
        startLiveCells = countLiveCells(currentBoard());

        // perform the game until the number of desired generations has been reached
        while (generations < iterations) {
            // for every cell
            for (int i = 0; i < currentBoard().length; i ++) {
                for (int j = 0; j < currentBoard().length; j ++) {
                    // reinforces the idea of a dead border (no cells can live on the border)
                    if (atBorder(currentBoard(), i, j)) {
                        // nextBoard() and currentBoard() are dependent on the booleans b1 and b2
                        nextBoard()[i][j] = 0;
                    }
                    else {
                        // if found a live cell
                        if (alive(currentBoard(), i, j)) {
                            // check live neighbors
                            if (checkNeighbors(currentBoard(), i, j) == 2 ||
                                    checkNeighbors(currentBoard(), i, j) == 3) {
                                // stay alive if it does
                                nextBoard()[i][j] = 1;
                            }
                            else {
                                // die
                                nextBoard()[i][j] = 0;
                            }
                        }
                        // if found a dead cell
                        else if (!alive(currentBoard(), i, j)) {
                            // count the number of live neighbors
                            if (checkNeighbors(currentBoard(), i, j) == 3) {
                                // if the number is 3,
                                // then the current cell comes to life
                                nextBoard()[i][j] = 1;
                            }
                            else {
                                nextBoard()[i][j] = 0;
                            }
                        }
                    }
                }
            }

            generations ++;

            // switch board
            if (b1) {
                b1 = false;
                b2 = true;
            }
            else if (b2) {
                b1 = true;
                b2 = false;
            }
        }

        // number of live cells at the end of the game
        endLiveCells = countLiveCells(nextBoard());
    }


    /**
     * perform a cross over with the two parents and then return their child
     *
     * @param parent1
     * @param parent2
     * @return
     */
    public static int [][] crossOver(int [][] parent1, int [][] parent2) {

        // initialize the child
        int [][] child = new int [M][M];

        // center area
        int spot = (parent1.length / 2) - 5;

        for (int row = spot; row < spot + N; row ++)
        {
            for (int column = spot; column < spot + N; column ++)
            {
                // use XOR
                if (parent1[row][column] == parent2[row][column])
                {
                    child[row][column] = 0;
                }
                else if (parent1[row][column] != parent2[row][column])
                {
                    child[row][column] = 1;
                }
            }
        }


        return child;
    }


    /**
     * This method mutates the array that is passed in
     * 1% of the time
     *
     * @param original
     * @return
     */
    public int [][] mutate(int [][] original)
    {
        // initialize the mutated array
        int [][] mutatedArray = new int [M][M];

        // Random rand = new Random();


        int spot = (original.length / 2) - 5;


        // iterate over the 8x8 array
        for (int row = spot; row < spot + N; row ++)
        {
            for (int column = spot; column < spot + N; column ++)
            {
                // true 1% of the time
                boolean val = rand.nextInt(101) < 1;

                // if its that 1% then mutate
                if (val && !atBorder(original, row, column))
                {
                    // mutate means to invert 1 to 0
                    // and 0 to 1
                    if (original[row][column] == 0)
                    {
                        mutatedArray[row][column] = 1;
                    }
                    else if (original[row][column] == 1)
                    {
                        mutatedArray[row][column] = 0;
                    }
                }
                else
                {
                    mutatedArray[row][column] = original[row][column];
                }
            }
        }


        return mutatedArray;
    }

    public void saveBox(int [][] array)
    {
        int spot = (array.length / 2) - 5;

        for (int row = spot; row < spot + N; row ++)
        {
            for (int column = spot; column < spot + N; column ++)
            {
                bestBox[row-spot][column-spot] = array[row][column];
            }
        }
    }


    /**
     * This is what is called from the main class.
     * This performs the genetic algorithm.
     *
     * @param desiredPop
     */
    public int[][] geneticAlgorithm(int desiredPop)
    {

        // start at iteration 0
        int iteration = 0;

        // initial best value
        best = Float.NEGATIVE_INFINITY;

        // this is the *unsorted* array of fitness values
        // I leave this unsorted because the indices in
        // the population list directly line up with
        // their fitness values in this array
        float [] fitnessVals = new float [desiredPop];

        // these two lines are only used for getting the
        // current system time and then add it to a set
        // number of hours
        long t = System.currentTimeMillis();
        long end = t + TimeUnit.MINUTES.toMillis(30);

        // used to only reference things in the population
        int index = 0;

        // construct the initial population
        while (index < desiredPop)
        {
            population.add(new int [M][M]);
            setUp(population.get(index));
            index ++;
        }

        // runs for the set amount of time

        while (System.currentTimeMillis() < end)
        {
            // retrieve each fitness value
            // population[1]'s fitness is at fitnessVals[1]
            for (int i = 0; i < population.size(); i ++)
            {
                run(1000, population.get(i));
                float num = endLiveCells / ((float)1.0 * startLiveCells);
                fitnessVals[i] = num;
            }

            // if we have a duplicate fitness then replace it
            for (int i = 0; i < fitnessVals.length; i ++)
            {
                for (int j = 0; j < fitnessVals.length; j ++)
                {
                    if (fitnessVals[j] == fitnessVals[i])
                    {
                        population.set(j, new int [M][M]);
                        setUp(population.get(j));
                        run(1000, population.get(j));
                        float num = endLiveCells / ((float)1.0 * startLiveCells);
                        fitnessVals[j] = num;
                    }
                }
            }

            // this makes it easier to find the largest fitness value
            // and then walk through the unordered fitness array and
            // compare the current fitness to the desired fitness until
            // we find the one we want
            float [] fitsOrdered = orderFitnesses(fitnessVals);

            fitness(fitsOrdered[0], iteration, fitsOrdered, fitnessVals);


            // new way for mutate
            // choose the parent population randomly by the getWeightedPopulation function
            ArrayList<int [][]> populationWithWeight = getWeightedPopulation(fitnessVals);

            for (int i = 0; i < population.size(); i++) {

                // Random rand = new Random();

                int pick1 = rand.nextInt(populationWithWeight.size());
                int pick2 = rand.nextInt(populationWithWeight.size());
                population.set(i, crossOver(populationWithWeight.get(pick1), populationWithWeight.get(pick2)));

            }


            for (int j = 0; j < population.size(); j ++) {

                int [][] mutated = mutate(population.get(findDesiredFit(fitnessVals, j + 1)));
                population.set(findDesiredFit(fitnessVals, j + 1), mutated);

            }


            iteration ++;
        }

        // display the best results
        System.out.println("\nBest Start Board: ");
        displayBoard(bestStart);

        System.out.println("\nBest Final Board: ");
        displayBoard(bestFinal);

        // System.out.println("\nBest 10x10 in compact: ");
        // displayCompactBoard(bestBox);
        System.out.println("\nBest Box: ");
        displayBoard(bestBox);

        System.out.println("\nBest Fitness: " + best);

        System.out.println("\nSeed: " + seed);

        return bestBox;
    }


    /**
     * According the fitness array, return a weighted population
     *
     * @param fitnessVals
     * @return
     */
    public ArrayList<int [][]> getWeightedPopulation(float[] fitnessVals) {

        ArrayList<int [][]> weithedP = new ArrayList<>();

        float totalFitness = 0;

        int[] possibilites = new int [fitnessVals.length];

        for (float fitness: fitnessVals) {
            totalFitness += fitness;
        }

        for (int i = 0; i < fitnessVals.length; i ++) {
            possibilites[i] = (int) (fitnessVals[i] / totalFitness * 100);
        }

        for (int i = 0; i < possibilites.length; i ++) {

            for (int j = 0; j < possibilites[i]; j++) {

                weithedP.add(population.get(findDesiredFit(fitnessVals, i + 1)));

            }

        }

        return weithedP;
    }


    /**
     * used in saving the arrays
     *
     * @param a1
     * @param a2
     */
    public void combineArrays(int [][] a1, int [][] a2)
    {
        for (int i = 0; i < a1.length; i ++)
        {
            for (int j = 0; j < a1.length; j ++)
            {
                a2[i][j] = a1[i][j];
            }
        }
    }


    /**
     * Used in determining if the found fitness is better than
     * the current best
     *
     * @param sol
     * @param iteration
     * @param vals
     */
    public void fitness(float sol, int iteration, float [] vals, float [] f) {
        if (sol > best && sol != Float.POSITIVE_INFINITY) {
            best = sol;
            System.out.println("Iteration: " + iteration + "     Best: " + best);
            bestStart = population.get(findDesiredFit(f, 1));
            run(1000, bestStart);
            bestFinal = nextBoard();
            saveBox(bestStart);
        }
        else if (sol == Float.POSITIVE_INFINITY) {
            for (int i = 0; i < vals.length; i ++) {
                if (vals[i] > best && vals[i] != Float.POSITIVE_INFINITY) {
                    best = vals[i];
                    System.out.println("Iteration: " + iteration + "     Best: " + best);
                    bestStart = population.get(findDesiredFit(f, 1));
                    run(1000, bestStart);
                    bestFinal = nextBoard();
                    saveBox(bestStart);
                    break;
                }
            }
        }
    }


    /**
     * Looks at the two boolean values and determines
     * which board is the current board
     *
     * @return
     */
    public int [][] currentBoard() {

        if (b1) {
            // on board1
            return board1;
        }
        else {
            // on board2
            return board2;
        }

    }


    /**
     * Returns the board that you want to modify based
     * off the cells in your current board
     *
     * @return
     */
    public int [][] nextBoard() {

        // if you're on board1
        // you want to modify board2
        if (b1) {
            return board2;
        }
        else {
            // otherwise modify board1
            return board1;
        }
    }


    /**
     * Sort the array from least to greatest then reverse it
     * so most fit is at position 0 in the array
     *
     * @param array
     * @return
     */
    public float [] orderFitnesses(float [] array) {

        float [] unsortedArray = array;
        float [] orderedArray = new float [unsortedArray.length];
        Arrays.sort(unsortedArray);
        int a = 0;

        for (int i = unsortedArray.length - 1; i > -1; i --) {
            orderedArray[a] = unsortedArray[i];
            a++;
        }

        return orderedArray;
    }


    /**
     * Runs through the unsorted float array and looks for the nth largest fitness
     *
     * @param array
     * @param nth
     * @return
     */
    public int findDesiredFit(float [] array, int nth) {

        float [] k = orderFitnesses(array);
        int index = 0;

        float desired = k[nth - 1];

        for (int i = 0; i < array.length; i ++) {
            if (array[i] == desired) {
                index = i;
            }
        }
        return index;
    }


    /**
     *  Determine how many live neighbors it has
     *
     * @param array
     * @param i
     * @param j
     * @return numAlive
     */
    public static int checkNeighbors(int [][] array, int i , int j) {

        // number of live neighboring cells
        int numAlive = 0;

        // use ternary and set the min/maxRow and min/maxCol
        // to the proper values only if they are not in the dead border
        int minRow = (i != 0) ? i - 1 : 0;
        int maxRow = (i != array.length - 1) ? i + 1: 0;

        int minCol = (j != 0) ? j - 1 : 0;
        int maxCol = (j != array.length - 1) ? j + 1: 0;

        // iterates over the neighboring cells and counts how many are alive
        for (int row = minRow; row <= maxRow; row++) {
            for (int column = minCol; column <= maxCol; column++) {
                if (array[row][column] == 1 && !(row == i && column == j)) {
                    numAlive++;
                }
            }
        }

        // finally return the number of live cells
        return numAlive;
    }


    /**
     * Used to check if the current cell is at the border
     *
     * @param array
     * @param i
     * @param j
     * @return
     */
    public static boolean atBorder(int [][] array, int i, int j) {

        // check if the cell is at the border
        if (i == array.length - 1 || i == 0 || j == 0 || j == array.length - 1) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Check if the current cell is alive or dead
     *
     * @param array
     * @param i
     * @param j
     * @return
     */
    public static boolean alive(int [][] array, int i, int j) {

        // current cell
        if (array[i][j] == 0) {
            return false;
        }
        else {
            return true;
        }
    }


    /**
     * Counts and returns the number of live cells in the board
     *
     * @param array
     * @return
     */
    public int countLiveCells(int [][] array) {

        int numAlive = 0;

        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length; j ++) {
                if (array[i][j] == 1) {
                    numAlive ++;
                }
            }
        }

        return numAlive;
    }


    /**
     * Display the board with 0's and 1's
     *
     * @param array
     */
    public void displayBoard(int [][] array) {

        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length; j ++) {
                if (array[i][j] == 0) {
                    System.out.print("0");
                }
                else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }

}
