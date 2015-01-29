/**
 * Written By : Lindsey Raymond
 * Created by lrraymond13 on 11/30/14.
 * NYU ID Number: N10905714
 * Plays Game of Life
 * Organism survive if 2 or 3 neighbors
 * Organisms grow if 3 neighbors
 * Generate generations according to initial input file
 * Continue generating generations while user 'plays'
 */


import java.io.*;
import java.util.Scanner;


public class GameofLife {

    final static int M = 25;
    final static int N = 75;


    public static void GameofLife(String[] args) {
        Scanner userinput = new Scanner(System.in);

        char userCommand = 'P';
        int genNumber = 0;


            System.out.println("Which file do you want to open?");
            String filename = userinput.nextLine();
            char[][] firstGen = firstGeneration(filename);
            System.out.println("Generation " + genNumber);
            printGeneration(firstGen);
            genNumber++;


            do {
                System.out.println("Enter 'P' to play or 'Q' to Quit");
                userCommand = userinput.nextLine().charAt(0);
                if (userCommand == 'P') {

                    char[][] nextGen = generateNext(firstGen);
                    System.out.println("Generation " + genNumber);
                    printGeneration(nextGen);
                    genNumber++;

                    if (sameWorld(firstGen, nextGen)) {
                        System.out.println("Next World is same as the previous world - Terminating Program");
                        System.exit(0);
                    }

                    if (emptyWorld(nextGen)) {
                        System.out.println("Empty world program is terminating");
                        System.exit(0);
                    }
                    //switch pointers
                    firstGen = nextGen;
                } else {
                    System.out.println("Thank you for playing - Ending program");
                }
            } while (userCommand == 'P');

        }

    public static char[][] firstGeneration(String filename) {

        char[][] CurrentGeneration = new char[M + 2][N + 2];

        File file = new File(filename);
        Scanner fileReader = null;

        try {
            fileReader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("file " + file + " does not exist");
            System.exit(0);
        }

        for (int i = 1; i <= M; i++) {
            String line = fileReader.nextLine();
            for (int j = 1; j <= N; j++) {
                CurrentGeneration[i][j] = line.charAt(j - 1);
            }
        }
      //fill in border
        for (int i=0; i< CurrentGeneration.length; i++) {

            for (int j=0; j < CurrentGeneration[0].length; j++) {
                if (i==0||i==M+1||j==0||j==N+1) {
                    CurrentGeneration[i][j] = '.';
                }
            }
        }
        return CurrentGeneration;

      }


    public static char[][] generateNext(char[][] currentGen) {
        char[][] NextGeneration = new char[M + 2][N + 2];


        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int totalNeighbors = numberNeighbors(currentGen, i, j);
                if ((totalNeighbors == 2 || totalNeighbors == 3) && (currentGen[i][j]=='X'||currentGen[i][j]=='x')){
                    NextGeneration[i][j] = 'X';
                } else if (totalNeighbors == 3 && currentGen[i][j]=='.') {
                    NextGeneration[i][j] = 'X';
                }
                else {
                    NextGeneration[i][j] = '.';
                }
            }

        }
        return NextGeneration;

    }

public static void printGeneration(char[][] NextGen) {

    for (int i = 0; i < NextGen.length ; i++) {
        for (int j = 0; j < NextGen[0].length; j++) {
            System.out.print(NextGen[i][j]);
        }
        System.out.println();
    }
}

    public static int numberNeighbors(char[][] charArray, int row, int col) {
        int totalNeighbors = 0;
        for (int k = -1; k <= 1; k++) {
            for (int j=-1; j<=1; j++) {
                int xcoord = row +k;
                int ycoord = col +j;
                char symbol = charArray[xcoord][ycoord];

                if (symbol == 'X' || symbol == 'x') {
                    if (xcoord==row && ycoord==col){
                        continue;}
                    totalNeighbors++;}
 }
        }
        return totalNeighbors;

    }


    public static boolean sameWorld(char[][] oldGen, char[][] newGen) {
        boolean same = true;

        for (int row=0; row<M; row++) {
            for (int col=0; col < N; col++) {
                if (oldGen[row][col] != newGen[row][col]) {
                    same = false;
                }
            }
        }
        return same;
    }

    public static boolean emptyWorld(char[][] charArray) {
        int totalLife = 0;
        for (int i = 1; i <= charArray.length - 2; i++) {
            for (int j = 1; j <= charArray[0].length - 2 ; j++) {
                if (charArray[i][j] == 'X') {
                    totalLife++;
                }
            } }
            if (totalLife > 0) {
                return false;
            }
            return true;
        }

    }




