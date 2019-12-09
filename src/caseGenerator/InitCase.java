package caseGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class InitCase {

    public static void createFile(int[][] matrix, long seed, long best){

        PrintWriter writer = null;
        int rows = matrix.length;
        int cols = matrix[0].length;

        File file = new File(cols+"_"+rows+"_"+ seed + "_" + best + ".txt");

        try {
            writer = new PrintWriter(new FileWriter(file));

            for (int y = 0; y < rows; y++) {
                StringBuilder sb = new StringBuilder();
                for (int x = 0; x < cols; x++) {

                    sb.append(matrix[y][x]);
                    sb.append(" ");

                }
                sb.deleteCharAt(sb.length()-1).append("\n");
                writer.write(sb.toString());
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

}
