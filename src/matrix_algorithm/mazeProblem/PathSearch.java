package matrix_algorithm.mazeProblem;

import java.util.Stack;

public class PathSearch {
    public static int NUMDIRECTIONS = 4;
    public static int WIDTH = 8;
    public static int HEIGHT = 8;

    Stack<Move> stack = new Stack<>();
    Move move;

    Maze maze = new Maze();

    public int[][] DIRECTION_OFFSET = {
            {1,  0}, //up
            {0,  1}, //right
            {-1, 0}, // down
            {0, -1}  // left
    };

    public static int NOTVISIT = 0;
    public static int WALL = 1;
    public static int VISIT = 2;

    int[][] markArray = new int[8][8];
    // markArray consists of visit or nonvisit but only prints 'visit'
    // maze consists of 0 & 1(nonvisit & wall), prints 'wall'.
    public void findPath(int startX, int startY, int endX, int endY) {
        boolean isEmpty = false;
        boolean isFound = false;

        Move start = new Move(startX, startY); // start point
        start.direction = 0;
        stack.push(start);

        while (isEmpty == false && isFound == false) {
            Move curPos = stack.pop();
            int x = curPos.x;   // start point initialization.
            int y = curPos.y;
            int direction = curPos.direction;

            while (isFound == false && direction < NUMDIRECTIONS) {
                int newX = x + DIRECTION_OFFSET[direction][1];
                int newY = y + DIRECTION_OFFSET[direction][0];
                if (newX >= 0
                        && newX < WIDTH
                        && newY >= 0
                        && newY < HEIGHT              //NONVISIT = 0;
                        && maze.myMaze[newX][newY] == NOTVISIT //because '0's are the path to the exit.
                        && markArray[newX][newY] == NOTVISIT) { //newly mark the path to markArray.
                    Move newPosition = new Move(newX, newY);
                    newPosition.direction = direction + 1;
                    stack.push(newPosition);
                    markArray[x][y] = VISIT;

                    x = newX; //initialization of variables for the next use.
                    y = newY;
                    direction = 0;
                    if (newX == endX && newY == endY) {
                        isFound = true;
                        newPosition.x = newX;
                        newPosition.y = newY;
                        newPosition.direction = 0;
                        stack.push(newPosition);
                        markArray[newX][newY] = VISIT;
                    }

                } else direction++; // if the conditions don't match, just change direction without move
            }
            isEmpty = stack.isEmpty(); //return
            // true ot false
        }
    }

    public void showPath() {
        int[][] resultArray = new int[8][8];
        boolean isEmpty = false;

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                resultArray[i][j] = maze.myMaze[i][j];
            }
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (maze.myMaze[i][j] == WALL) {
                    System.out.print("@");
                }
                else if (markArray[i][j] == VISIT) {
                    System.out.print("O");
                }
                else {
                    System.out.print("X");
                }
            }
            System.out.print("\n");
        }
        int i =0;
        while (isEmpty == false) {
            Move move = stack.pop();
            int x = move.x;
            int y = move.y;
            resultArray[x][y] = VISIT;
            if (i > 0) {
                System.out.print("<-");
            }
            System.out.print("( "+x+", "+y+" )");
            i++;
            isEmpty = stack.isEmpty();
        }
        System.out.println();
    }

}
