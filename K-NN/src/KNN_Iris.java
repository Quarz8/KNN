// Course:          CS4267
// Student name:    Warren Davis
// Student ID:      000545250
// Assignment #:    #1
// Due Date:        September 16, 2019
// Signature:       _________________
// Score:           _________________

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KNN_Iris
{
    static double getMax(double a, double b)
    { // returns larger double
        if (a >= b)
            return a;
        else
            return b;
    }

    static double getMin(double a, double b)
    { // returns smaller double
        if (a <= b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        // Data set scanner
        Scanner s = new Scanner(new File("IrisSpecies"));
        s.useDelimiter(",|\\s+"); // comma or new line set as delimiters

        // Array list to hold data points
        ArrayList<DataPoint> dataList = new ArrayList<DataPoint>();

        // Create list of all data points for use in code
        while (s.hasNext())
        {
            DataPoint temp = new DataPoint(s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble(), s.next());
            dataList.add(temp);
        }
        s.close();

        Scanner input = new Scanner(System.in); // scanner for reading user input

        // Ask for K. 1, 3, 5, etc...
        System.out.print("Enter an integer for K: ");
        int K = input.nextInt();

        // Ask for new data point
        System.out.print("Enter new data point with attributes separated by a space: ");
        DataPoint temp = new DataPoint(input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble());
        dataList.add(temp);
        input.close();

        // max and min of each attribute, defaulted to first attribute values...
        double maxSL = dataList.get(0).getSepalLength(), maxSW = dataList.get(0).getSepalWidth(),
                maxPL = dataList.get(0).getPetalLength(), maxPW = dataList.get(0).getPetalWidth();

        double minSL = dataList.get(0).getSepalLength(), minSW = dataList.get(0).getSepalWidth(),
                minPL = dataList.get(0).getPetalLength(), minPW = dataList.get(0).getPetalWidth();

        // Find max and min of each attribute
        for (int i = 0; i < dataList.size(); i++)
        {
            maxSL = getMax(maxSL, dataList.get(i).getSepalLength());
            maxSW = getMax(maxSW, dataList.get(i).getSepalWidth());
            maxPL = getMax(maxPL, dataList.get(i).getPetalLength());
            maxPW = getMax(maxPW, dataList.get(i).getPetalWidth());

            minSL = getMin(minSL, dataList.get(i).getSepalLength());
            minSW = getMin(minSW, dataList.get(i).getSepalWidth());
            minPL = getMin(minPL, dataList.get(i).getPetalLength());
            minPW = getMin(minPW, dataList.get(i).getPetalWidth());
        }

        // Normalize all the attributes to range from 0-1 using x=(x-xMin)/(xMax-xMin)
        for (int i = 0; i < dataList.size(); i++)
        {
            dataList.get(i).setSepalLength((dataList.get(i).getSepalLength() - minSL) / (maxSL - minSL));
            dataList.get(i).setSepalWidth((dataList.get(i).getSepalWidth() - minSW) / (maxSW - minSW));
            dataList.get(i).setPetalLength((dataList.get(i).getPetalLength() - minPL) / (maxPL - minPL));
            dataList.get(i).setPetalWidth((dataList.get(i).getPetalWidth() - minPW) / (maxSL - minPW));
        }

        // list of Euclidean distances between training datapoints and new datapoint
        ArrayList<Double> distanceList = new ArrayList<Double>();

        // calculate Euclidean distances between
        // all training datapoints and the new datapoint
        // and add to distanceList
        for (int i = 0; i < dataList.size() - 1; i++)
        {
            double a1 = dataList.get(i).getSepalLength();
            double a2 = dataList.get(i).getSepalWidth();
            double a3 = dataList.get(i).getPetalLength();
            double a4 = dataList.get(i).getPetalWidth();

            double b1 = dataList.get(dataList.size() - 1).getSepalLength();
            double b2 = dataList.get(dataList.size() - 1).getSepalWidth();
            double b3 = dataList.get(dataList.size() - 1).getPetalLength();
            double b4 = dataList.get(dataList.size() - 1).getPetalWidth();

            double distance = Math
                    .sqrt(Math.pow(a1 - b1, 2) + Math.pow(a2 - b2, 2) + Math.pow(a3 - b3, 2) + Math.pow(a4 - b4, 2));
            distanceList.add(distance);
        }
        // find shortest distances, then find those
        // distances in distanceList to get index of dataPoint
        // Sorted version of distanceList from least to greatest
        ArrayList<Double> sortedDistances = new ArrayList<Double>(distanceList);
        Collections.sort(sortedDistances);

        ArrayList<Integer> nearestNeighborIndicies = new ArrayList<Integer>();
        // correspond orderedDistances to distanceList indicies
        for (int i = 0; i < K; i++)
        {
            for (int j = 0; j < distanceList.size(); j++)
            {
                if (sortedDistances.get(i) == distanceList.get(j))
                {
                    nearestNeighborIndicies.add(j);
                    break;
                }
            }
        }
        int setosa = 0;
        int versicolor = 0;
        int virginica = 0;
        // loops until there is a majority in K
        while (true)
        {
            setosa = 0;
            versicolor = 0;
            virginica = 0;

            // Find labels of K nearestNeighbors using indicies
            // related ti dataList
            for (int i = 0; i < K; i++)
            {
                switch (dataList.get(nearestNeighborIndicies.get(i)).getLabel())
                {
                case "Iris-setosa":
                    setosa++;
                    break;
                case "Iris-versicolor":
                    versicolor++;
                    break;
                case "Iris-virginica":
                    virginica++;
                    break;
                default:
                    System.out.println("That's not good tbqhwy famalam"); // label system broke...
                }
            }

            // Assign label based on majority K and break while loop
            if (setosa > versicolor && setosa > virginica)
            {
                dataList.get(dataList.size() - 1).setLabel("Iris-setosa");
                break;
            }
            else if (versicolor > setosa && versicolor > virginica)
            {
                dataList.get(dataList.size() - 1).setLabel("Iris-versicolor");
                break;
            }
            else if (virginica > setosa && virginica > versicolor)
            {
                dataList.get(dataList.size() - 1).setLabel("Iris-virginica");
                break;
            }
            else
                K--; // reduce K by 1 and try again if there was no single majority
        }

        // Output results for user
        System.out.println("K(" + K + ") Nearest Neighbors are: " + setosa + " Iris setosa, " + versicolor
                + " Iris versicolor, and " + virginica + " Iris virginica.");
        System.out.println("Data is likely: " + dataList.get(dataList.size() - 1).getLabel());

    } // end main method
}