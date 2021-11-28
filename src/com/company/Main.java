package com.company;

import java.util.*;

public class Main {

    public ArrayList<Point> test1 = new ArrayList<>();
    public ArrayList<Point> test2 = new ArrayList<>();
    public ArrayList<Point> test3 = new ArrayList<>();
    public ArrayList<Point> test4 = new ArrayList<>();

    public double calculateSlope(Point p1, Point p2) {
        float m = (float) (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());//Given two points iteration p1(i) and p2(j) the slope of the points will be calculated
        return m; // The slope will then be returned for the next method to find the equation
    }

    public String findEquation(Point p1, Point p2) {
        if (p2.getY() - p1.getY() == 0) { //If the points are horizontal the equation will just be the y = and the y value of point 2
            return "y = " + p2.getY(); //The equation for the horizontal line will be returned
        }
        if (p2.getX() - p1.getX() == 0) { //If the points are vertical the equation will just be x = and then the x value of point 2
            return "x = " + p2.getX(); //The equation for the horizontal line will be returned
        }
        double m = calculateSlope(p1, p2); //The slope will be calculated if it's not horizontal or vertical
        //The slope intercept form is used to achieve the equation for the line (y=mx+b)
        return "y = " + m + " * " + "x" + " + " + ((-m * p2.getX()) + p2.getY()); //The equation will be returned
    }

    public void bubbleSort(ArrayList<Point> points) {
        for (int i = 0; i < points.size() + 1; i++) { //O(n)
            for (int j = 0; j < points.size() - i - 1; j++) { //O(n^2)
                if (points.get(j).getY() > points.get(j + 1).getY()) { //In this if statement the Y value and the next Y value will be checked to see if the current Y value is bigger
                    Collections.swap(points, j, j + 1); //If so both of them will be swapped
                }
                if (points.get(j).getX() > points.get(j + 1).getX()) { //In this if statement the X value and the next X value will be checked to see if the current X value is bigger
                    Collections.swap(points, j, j + 1); // If so both of them will be swapped
                }
            }
            //This will be repeated until sorted
        } //O(n^2)
        //It is also possible to use the builtin sort method which uses the merge sort, quick sort and tim sort which has a time complexity of n log(n) using the collections.sort() method
    }

    public void printPoints(Map<String, ArrayList<Point>> allPoints) {
        ArrayList<Point> value = new ArrayList<>(); //This arraylist will be used to find the size of the array
        System.out.print("{"); //"{" will be added before every array
        for (Map.Entry<String, ArrayList<Point>> entry : allPoints.entrySet()) { // Map.Entry is used to gain access to the entry which provides us different methods. The purpose is to access the entry.getValue() method
                                                                                //  A set will then be looped which is created based on the map (allPoints.entrySet())
            ArrayList<Point> points = entry.getValue(); //The values will then be set to this attribute in each iteration
            if (points.size() >= 4) { //We then want every value with 4+ points in the arraylist
                System.out.print(entry.getValue() + ","); //Each value will be printed out
                value = entry.getValue(); //Lastly the value in the map will be set to this attribute
            }
        }

        if (value.size() == 0) {  //The value in the map will be checked if it's empty
            System.out.println("\b{}");//The comma before "{}" will be deleted by "\b"

        } else {
            System.out.println("\b}"); //The comma before "}" will be deleted by "\b"
        }
    } //O(n)

    public void update(Map<String, ArrayList<Point>> m, String key, Point value1, Point value2) {
        ArrayList<Point> list = m.get(key); //We want to retrieve the values based on the key
        if (list == null) { //If there is no value based on the key
            list = new ArrayList<>(); //A new arraylist will be created as the value
            m.put(key, list); //And insert the key and the values which is the arraylist from the line above
        }
        if (!(list.contains(value1))) { //the list will be checked if it already contains value1
            list.add(value1);           //If not value 1 will be added
        } //O(n)
        if (!(list.contains(value2))) { //the list will be checked if it already contains value2
            list.add(value2); // If not value2 will be added
        } //O(n)
    }

    public void listOfPoints(ArrayList<Point> points) {
        Map<String, ArrayList<Point>> allPoints = new TreeMap<>(); // The TreeMap is created to store the equations of the line that the points are on as the key and the collinear points (in the arraylist) as value in the map
        bubbleSort(points); //bubbleSort will be used to sort the values
        int n = points.size(); //The size of the arraylist which holds the points will be set to n
        while (n > 1) { // We create our while loop to iterate while the size of the arraylist (points) is bigger than 1. Has a O(log (n)) as time complexity
            n = n / 2; //n will be divided with 2 to achieve O(log (n))
            for (int i = 0; i < points.size(); i++) { //O(n)
                for (int j = i + 1; j < points.size(); j++) { //O(n^2) because of nested for loop

                    String equation = findEquation(points.get(i), points.get(j)); //The findEquation method will be used to get the slope intercept form
                    update(allPoints, equation, points.get(i), points.get(j)); //The allPoints map will be updated with the equation as the key and point i and j as the value
                }
            }
        }
        printPoints(allPoints); //Lastly printPoints method will be called to print out the result
    } //O(n^2 log(n))

    public static void main(String[] args) {
        Main main = new Main();

        main.test1.add(new Point(7, 1));
        main.test1.add(new Point(12, 3));
        main.test1.add(new Point(14, 6));
        main.test1.add(new Point(9, 4));
        main.test1.add(new Point(1, 6));
        main.test1.add(new Point(1, 1));
        main.test1.add(new Point(2, 2));
        main.test1.add(new Point(3, 3));
        main.test1.add(new Point(4, 4));
        main.test1.add(new Point(1, 2));
        main.test1.add(new Point(2, 4));
        main.test1.add(new Point(3, 6));
        main.test1.add(new Point(4, 7));

        main.test2.add(new Point(7, 1));
        main.test2.add(new Point(12, 5));
        main.test2.add(new Point(14, 6));
        main.test2.add(new Point(9, 4));
        main.test2.add(new Point(1, 6));
        main.test2.add(new Point(2, 2));
        main.test2.add(new Point(3, 3));
        main.test2.add(new Point(4, 4));
        main.test2.add(new Point(1, 2));
        main.test2.add(new Point(2, 4));
        main.test2.add(new Point(3, 6));
        main.test2.add(new Point(4, 7));

        main.test3.add(new Point(7, 1));
        main.test3.add(new Point(12, 3));
        main.test3.add(new Point(14, 6));
        main.test3.add(new Point(9, 4));
        main.test3.add(new Point(1, 6));
        main.test3.add(new Point(2, 1));
        main.test3.add(new Point(1, 4));
        main.test3.add(new Point(1, 5));
        main.test3.add(new Point(4, 4));
        main.test3.add(new Point(1, 2));
        main.test3.add(new Point(2, 5));
        main.test3.add(new Point(3, 6));
        main.test3.add(new Point(4, 8));

        main.test4.add(new Point(2, 2));
        main.test4.add(new Point(3, 3));
        main.test4.add(new Point(4, 4));
        main.test4.add(new Point(7, 1));
        main.test4.add(new Point(14, 6));
        main.test4.add(new Point(9, 4));
        main.test4.add(new Point(1, 1));
        main.test4.add(new Point(1, 4));
        main.test4.add(new Point(1, 5));
        main.test4.add(new Point(1, 2));
        main.test4.add(new Point(2, 4));
        main.test4.add(new Point(6,6));

        main.listOfPoints(main.test1);
        main.listOfPoints(main.test2);
        main.listOfPoints(main.test3);
        main.listOfPoints(main.test4);

    }

}
