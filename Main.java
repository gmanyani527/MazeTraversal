import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
    private static char[][] maze;
    private static int startRow, startCol;
    private static boolean pathFound = false;


    public static boolean createMaze(String filePath){
        try{
            File file = new File(filePath);
            Scanner translator = new Scanner(file);
            int rows = translator.nextInt();
            int cols = translator.nextInt();

            translator.nextLine();

            maze = new char [rows][cols];

            for( int i = 0; i < rows; i++){
                String line = translator.nextLine();
                for(int j = 0; j < cols; j++){
                    maze[i][j] = line.charAt(j);
                    if(maze[i][j] == '+'){
                        startRow = i;
                        startCol = j;
                    }
                }
            }
            translator.close();
            return true;
        } catch(FileNotFoundException e){

            e.printStackTrace();
            return false;
        }
    }

    public static void printMaze(){
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public static char North(int row, int col){
        if(row - 1 >= 0)
            return maze[row-1][col];
        
        return 'X';

    }
    public static char South(int row, int col){
        if (row + 1 < maze.length)
            return maze[row+1][col];
        return 'X';
    }

    public static char East(int row, int col){
        if(col + 1 < maze[row].length){
            return maze[row][col + 1];
        }  
        return 'X';
    }

    public static char West(int row, int col){
        if(col- 1 >= 0)
            return maze[row][col - 1];
        return 'X';
    }

    public static void solveMaze(int row, int col){
        if( East(row,col) == '-' || West(row,col) == '-' || South(row,col) == '-' || North(row, col) == '-'){
            maze[row][col] = '+';
            pathFound = true;
            return;
        }
        else{
            if(East(row, col) == ' '){
                maze[row][col] = '+';
            solveMaze(row,col+1);
                if(pathFound)
                    return;
            }
            if(West(row,col) == ' '){
                maze[row][col] = '+';
            solveMaze(row, col - 1);
                if(pathFound)
                    return;
            }
            if(North(row, col) == ' '){
                maze[row][col] = '+';
            solveMaze(row - 1, col);
                if(pathFound)
                    return;
            }
            if(South(row, col) == ' '){
                maze[row][col] = '+';
            solveMaze(row + 1, col);
                if(pathFound)
                    return;
            }
            maze[row][col] = '.';

        }
    }



    public static void main(String[] args) {
        if(createMaze("maze.dat")){
            solveMaze(startRow, startCol);
                System.out.println("Solved!!!");
            
                printMaze();
        }
        else{
            System.out.println("Maze Unavailable");
        }
    }
    
}
