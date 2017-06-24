package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class RobotInGrid
{

    private static List<String> paths = new ArrayList<String>();

    private static void robotInGrid (int[][] matrix, int row, int coloumn)
    {
        if (row == matrix.length - 1 && coloumn == matrix[row].length - 1)
        {
            matrix[row][coloumn] = 1;
            paths.add("(" + row + "," + coloumn + ")");
            return ;
        }

        if (row > matrix.length - 1 || coloumn > matrix[row].length - 1)
        {
            return ;
        }

        if (matrix[row][coloumn] == 1)
            return ;

        matrix[row][coloumn] = 1;

        paths.add("(" + row + "," + coloumn + ")");
        
         robotInGrid(matrix, row+1, coloumn);
         robotInGrid(matrix, row, coloumn+1);

    }

    public static void main (String[] args)
    {

        RobotInGrid.robotInGrid(new int[4][3], 0, 0);
        for (String path  : paths)
        {
            System.out.println(path);
        }
        System.out.println();
    }

}
