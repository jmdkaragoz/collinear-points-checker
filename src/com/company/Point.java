package com.company;

public class Point {

    private int x; //The x value for a point
    private int y; //the y value for a point

    public Point(int x, int y) { //Assign the given X and Y value to the local attributes
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() { //Convert the points to string to output the points in the desired format
        return "{" + x + "," + y + "}";

    }

    public int getX() { //Getter for X value
        return x;
    }

    public int getY() { //Getter for Y value
        return y;
    }

}