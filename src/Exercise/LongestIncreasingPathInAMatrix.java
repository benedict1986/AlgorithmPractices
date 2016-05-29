/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise;
import Exercise.LongestIncreasingPathInAMatrix.Cell;
/**
 *
 * @author Admin
 */
public class LongestIncreasingPathInAMatrix {
   
    public static void main(String[] args)
    {
        LongestIncreasingPathInAMatrix lip = new LongestIncreasingPathInAMatrix();
        int matrix[][] = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(lip.longestIncreasingPath(matrix));
    }
    
    public class Cell
    {
        public int row;
        public int column;
        public int value;
        
        public Cell(int row, int column, int value)
        {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
    
    public Cell[] cells;
    public int[][] maxLength;
    public int longestIncreasingPath(int[][] matrix) {
        
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        this.maxLength = new int[rowCount][columnCount];
        int totalElementCount = rowCount * columnCount;
        cells = new Cell[totalElementCount];
        int r, c, i=0;
        // Create cell array
        for(r = 0; r < rowCount; r++)
        {
            for (c = 0; c < columnCount; c++)
            {
                cells[i++] = new Cell(r, c, matrix[r][c]);
            }
        }
        // Find max
        int max = -9999;
        for(i = 0; i < totalElementCount; i++)
        {
            if (cells[i].value > max)
                max = cells[i].value;
        }
        int[] temp = new int[max+1];
        for(i=0;i < totalElementCount; i++)
        {
            temp[cells[i].value]++;
        }
        int tempTotalElementCount = totalElementCount;
        for(i = max; i >=0 ;i--)
        {
            tempTotalElementCount = tempTotalElementCount - temp[i];
            temp[i] = tempTotalElementCount;
        }
        Cell[] sortedCells = new Cell[totalElementCount];
        for(i = 0; i < totalElementCount; i++)
        {
            sortedCells[temp[cells[i].value]] = cells[i];
            temp[cells[i].value]++;
        }
        
        return CountLIP(sortedCells, matrix);
    }

    public int CountLIP(Cell[] cells, int[][] matrix)
    {
        int totalElementCount = cells.length;
        int max = 0, tempMax;
        for(int i = 0; i < totalElementCount; i++)
        {
            tempMax = CountLIPAssistant(matrix, cells[i].row, cells[i].column) + 1;
            max = max > tempMax? max: tempMax;
        }
        return max;
    }
    
    public int CountLIPAssistant(int[][] matrix, int row, int column)
    {
        if (this.maxLength[row][column] != 0)
            return this.maxLength[row][column];
        
        int countUp = 0, countDown = 0, countLeft = 0, countRight = 0;
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        if ((row < 0 || row >= rowCount) || (column < 0 || column >= columnCount))
            return Math.max(Math.max(Math.max(countUp, countDown), countLeft), countRight);
        
        int value = matrix[row][column];
        if (column-1 >= 0 && matrix[row][column-1] > value) // left
        {
            countLeft += CountLIPAssistant(matrix, row, column-1) + 1;
        }
        if (column+1 < columnCount && matrix[row][column+1] > value) // right
        {
            countRight += CountLIPAssistant(matrix, row, column+1) + 1;
        }
        if (row-1 >= 0 && matrix[row-1][column] > value) //up
        {
            countUp += CountLIPAssistant(matrix, row-1, column) + 1;
        }
        if (row+1 < rowCount && matrix[row+1][column] > value) // down
        {
            countDown += CountLIPAssistant(matrix, row+1, column) + 1;
        }
        
        int max = Math.max(Math.max(Math.max(countUp, countDown), countLeft), countRight);
        this.maxLength[row][column] = max;
        return max;
    }
}
