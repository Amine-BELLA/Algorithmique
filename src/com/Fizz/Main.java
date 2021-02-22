package com.Fizz;


import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
//    0=wall
//    1=path
//    2=destination

    public static void main(String[] args) {
	    int[][] maze = {
                {2,0,1,1},
                {1,1,1,0},
                {0,1,1,1}
        };
        Position startPosition = new Position(0,3);
        LinkedList<Position> path = new LinkedList<Position>();
        path.push(startPosition);

        while (true) {
            int x = path.peek().getX();
            int y = path.peek().getY();
            maze[x][y] = 0;

            //down
            if (isValid(maze,x+1,y)) {
                if (maze[x+1][y] == 2) {
                    System.out.println("Down, You've won!");
                    return;
                }
                else if (maze[x+1][y] == 1) {
                    path.push(new Position(x+1,y));
                    System.out.println("Down");
                    continue;
                }
            }

            //left
            if (isValid(maze,x,y-1)) {
                if (maze[x][y-1] == 2) {
                    System.out.println("Left, You've won!");
                    return;
                }
                else if (maze[x][y-1] == 1) {
                    path.push(new Position(x,y-1));
                    System.out.println("Left");
                    continue;
                }
            }

            //up
            if (isValid(maze,x-1,y)) {
                if (maze[x-1][y] == 2) {
                    System.out.println("Up, You've won!");
                    return;
                }
                else if (maze[x-1][y] == 1) {
                    path.push(new Position(x-1,y));
                    System.out.println("Up");
                    continue;
                }
            }

            //right
            if (isValid(maze,x,y+1)) {
                if (maze[x][y+1] == 2) {
                    System.out.println("Right, You've won!");
                    return;
                }
                else if (maze[x][y+1] == 1) {
                    path.push(new Position(x,y+1));
                    System.out.println("Right");
                    continue;
                }
            }

            path.pop();
            if (path.size() <= 0) {
                System.out.println("No path found");
            }
        }
    }

    public static boolean isValid(int[][] maze,int x, int y) {
        if (y<0 || x<0 || x>=maze.length || y>=maze[0].length) {
            return false;
        }
        return true;
    }
}
