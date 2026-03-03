package backtracking;

public class sudoku {

    public static boolean isSafe(int sudoku[][] , int row , int col , int digit){
         //column 
         for (int i = 0 ; i<9 ;i++){
            if(sudoku [i][col]==digit){
                return false;
            }
         }

         //row
         for (int j = 0 ; j< 9 ; j++){
            if(sudoku[row][j]==digit){
                return false;
            }
         }

            //grid
            int sr = (row/3)*3;
            int sc = (col/3)*3;

            for (int i = sr ;i<sr+3 ; i++){
                for(int j = sc ; j<sc+3;j++){
                    if(sudoku[i][j]== digit){
                        return false;
                    }
                }
            }
            return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row , int col) {
//base case
if (row ==9){
    return true;
}
    // recursive case
    int nextRow = row , nextcol  = col+1;
    if (col+1 == 9){
        nextRow = row +1;
        nextcol = 0 ;

    }
    if(sudoku[row][col]!=0){
        return sudokuSolver(sudoku , nextRow , nextcol);

    }
    for (int digit = 1 ; digit <=9 ; digit ++){
        if (isSafe(sudoku, row , col , digit)){
            sudoku[row][col] = digit;
            if(sudokuSolver(sudoku , nextRow , nextcol)){
                return true;
            }
            sudoku[row][col] = 0;     
        }
    }
    return false;

    }

    public static void main(String[] args) {
        int sudoku[][] = {
    {0,0,8,0,0,0,0,0,0},
    {4,9,0,1,5,7,0,0,2},
    {0,0,3,0,0,4,1,9,0},
    {1,8,5,0,6,0,7,2,0},
    {0,0,0,0,2,0,0,0,0},
    {0,2,6,0,7,0,8,4,1},
    {0,9,1,4,0,0,3,0,0},
    {7,0,0,9,1,5,0,6,8},
    {0,0,0,0,8,0,5,0,0}
};
        if(sudokuSolver(sudoku , 0 , 0)){
            for (int i = 0 ; i<9 ; i++){
                for (int j = 0 ; j<9 ; j++){
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println("solution does not exist");
        }
    }
}
