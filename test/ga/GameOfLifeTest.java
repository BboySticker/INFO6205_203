package ga;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import ga.GameOfLife;

import java.lang.reflect.Method;

/**
 * GameOfLife Tester.
 *
 * @author <Authors name>
 * @since <pre>Dec 8, 2019</pre>
 * @version 1.0
 */
public class GameOfLifeTest {

    @Befgore
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: geneticAlgorithm(int desiredPop)
     *
     */
    @Test
    public void testGeneticAlgorithm() throws Exception {
//TODO: Test goes here... 
    }

    /**
     *
     * Method: getPopulation(int desiredPop)
     *
     */
    @Test
    public void testGetPopulation() throws Exception {
//TODO: Test goes here... 
    }


    /**
     *
     * Method: randomStart(int [][] box)
     *
     */
    @Test
    public void testRandomStart() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("randomStart", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: fillBoard(int [][] array)
     *
     */
    @Test
    public void testFillBoard() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("fillBoard", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: setUp(int [][] array)
     *
     */
    @Test
    public void testSetUp() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("setUp", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: run(int iterations, int [][] array)
     *
     */
    @Test
    public void testRun() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("run", int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: crossOver(int [][] parent1, int [][] parent2)
     *
     */
    @Test
    public void testCrossOver() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("crossOver", int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: mutate(int [][] original)
     *
     */
    @Test
    public void testMutate() throws Exception {
//TODO: Test goes here...
        int[][] test1 = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 1} };

        int[][] test2 = {
                {0, 0, 1},
                {1, 0, 0},
                {1, 1, 0} };

        int[][] result = GameOfLife.crossOver(test1,test2,3,3,3);
        int[][] expected = {
                {0, 1, 1},
                {1, 0, 0},
                {0, 0, 1} };
        Assert.assertEquals(expected,result);
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("mutate", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: saveBox(int [][] array)
     *
     */
    @Test
    public void testSaveBox() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("saveBox", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: combineArrays(int [][] a1, int [][] a2)
     *
     */
    @Test
    public void testCombineArrays() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("combineArrays", int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: fitness(float sol, int iteration, float [] vals, float [] f)
     *
     */
    @Test
    public void testFitness() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("fitness", float.class, int.class, float.class, float.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: getFitnessVal(int iteration, int[][] patternGrid)
     *
     */
    @Test
    public void testGetFitnessVal() throws Exception {
//TODO: Test goes here...
        GameOfLife gl = new GameOfLife();
        int[][] test = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 1}
        };


        Method testParamMethod = gl.getClass().getDeclaredMethod("getFitnessVal",new Class[]{int.class,int[][].class});
        testParamMethod.setAccessible(true);
        //调用
        Object result = testParamMethod.invoke(gl,new Object[]{3,test});
        System.out.println(result);
        Assert.assertEquals(0.57,(float)result,0.1);
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("getFitnessVal", int.class, int[][].class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: currentBoard()
     *
     */
    @Test
    public void testCurrentBoard() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("currentBoard"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: nextBoard()
     *
     */
    @Test
    public void testNextBoard() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("nextBoard"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    

    /**
     *
     * Method: findDesiredFit(float [] array, int nth)
     *
     */
    @Test
    public void testFindDesiredFit() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("findDesiredFit", float.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: checkNeighbors(int [][] array, int i, int j)
     * public static int checkNeighbors(int [][] array, int i , int j)
     */
    @Test
    public void testCheckNeighbors() throws Exception {
//TODO: Test goes here...
        int result = 4;
        int[][] test = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 1}
        };
        Assert.assertEquals(4,GameOfLife.checkNeighbors(test,1,1));

/* 
try { 
   Method method = GameOfLife.getClass().getMethod("checkNeighbors", int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: atBorder(int [][] array, int i, int j)
     *
     */


    @Test
    public void testAtBorder() throws Exception {
//TODO: Test goes here...
        int[][] test = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 1} };
        Boolean result = GameOfLife.atBorder(test,1,2);
        Assert.assertEquals(true,result);
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("atBorder", int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: alive(int [][] array, int i, int j)
     *
     */


    @Test
    public void testAlive() throws Exception {
//TODO: Test goes here...
        int[][] test = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 1} };
        Boolean expected = false;
        Boolean result = GameOfLife.alive(test,0,0);
        Assert.assertEquals(expected,result);

/* 
try { 
   Method method = GameOfLife.getClass().getMethod("alive", int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: countLiveCells(int [][] array)
     *
     */
    @Test
    public void testCountLiveCells() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("countLiveCells", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: displayCompactBoard(int [][] array)
     *
     */
    @Test
    public void testDisplayCompactBoard() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("displayCompactBoard", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: displayBoard(int [][] array)
     *
     */
    @Test
    public void testDisplayBoard() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = GameOfLife.getClass().getMethod("displayBoard", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
