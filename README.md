Maze Solver
Overview
The Maze Solver is a Java program that reads a maze configuration from a file, solves the maze using a recursive depth-first search (DFS) algorithm, and prints the solved maze to the console. The program identifies the start position (+) within the maze and attempts to find a path to the exit (-), marking the path along the way.


Reads a maze layout from a file.
Identifies the start position and navigates the maze recursively.
Marks the path to the exit if a solution exists.
Displays the solved maze in the console.

The input file (e.g., maze.dat) must follow this structure:

The first line specifies the number of rows and columns in the maze.
The subsequent lines represent the maze, where:
+ represents the starting point.
- represents the exit.
X represents walls or obstacles.
(space) represents open paths.
Example Input File (maze.dat)

How It Works: 
The maze is read from the input file and stored as a 2D array.
The program locates the starting position (+).
It recursively explores all possible directions (north, south, east, west):
Marks valid paths as part of the solution (+).
Backtracks and marks dead ends with ..
If a solution is found, the program prints the solved maze with the path from the start to the exit.

Prerequisites:
Java Development Kit (JDK) installed on your system.
Steps to Run
Prepare an input file (e.g., maze.dat) with the maze configuration.
Compile the program:
bash
Copy code
javac Main.java
Run the program:
bash
Copy code
java Main
If the maze file is valid, the solved maze will be displayed in the console.

Error Handling
If the input file is not found, the program will print Maze Unavailable and terminate.
If no solution exists, the program will mark the attempted paths with . in the maze.
 
