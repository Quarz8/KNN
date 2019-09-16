
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

public class KNN_HeartDisease
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
        Scanner s = new Scanner(new File("HeartDisease"));
        s.useDelimiter("\\s+"); // comma or new line set as delimiters

        // Array list to hold data points
        ArrayList<DataPoint> dataList = new ArrayList<DataPoint>();

        // Create list of all data points for use in code
        while (s.hasNext())
        {
            DataPoint temp = new DataPoint(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(),
                    s.nextInt(), s.nextInt(), s.nextInt(), s.nextDouble(), s.nextInt(), s.nextInt(), s.nextInt(),
                    s.nextInt());
            dataList.add(temp);
        }
        s.close();

        Scanner input = new Scanner(System.in); // scanner for reading user input

        // Ask for K. 1, 3, 5, etc...
        System.out.print("Enter an integer for K: ");
        int K = input.nextInt();

        // Ask for new data point
        System.out.print("Enter new data point with attributes separated by a space: ");
        DataPoint temp = new DataPoint(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(),
                input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextDouble(),
                input.nextInt(), input.nextInt(), input.nextInt());
        dataList.add(temp);
        input.close();

        // max and min of each attribute, defaulted to first attribute values...
        double maxAge = dataList.get(0).getAge(), maxSex = dataList.get(0).getSex(),
                maxCP = dataList.get(0).getChestpain(), maxTrestbps = dataList.get(0).getTrestbps(),
                maxChol = dataList.get(0).getChol(), maxFbs = dataList.get(0).getFbs(),
                maxRestecg = dataList.get(0).getRestecg(), maxThalach = dataList.get(0).getThalach(),
                maxExang = dataList.get(0).getExang(), maxOldpeak = dataList.get(0).getOldpeak(),
                maxSlope = dataList.get(0).getSlope(), maxCa = dataList.get(0).getCa(),
                maxThal = dataList.get(0).getThal();

        double minAge = dataList.get(0).getAge(), minSex = dataList.get(0).getSex(),
                minCP = dataList.get(0).getChestpain(), minTrestbps = dataList.get(0).getTrestbps(),
                minChol = dataList.get(0).getChol(), minFbs = dataList.get(0).getFbs(),
                minRestecg = dataList.get(0).getRestecg(), minThalach = dataList.get(0).getThalach(),
                minExang = dataList.get(0).getExang(), minOldpeak = dataList.get(0).getOldpeak(),
                minSlope = dataList.get(0).getSlope(), minCa = dataList.get(0).getCa(),
                minThal = dataList.get(0).getThal();

        // Find max and min of each attribute
        for (int i = 0; i < dataList.size(); i++)
        {
            maxAge = getMax(maxAge, dataList.get(i).getAge());
            maxSex = getMax(maxSex, dataList.get(i).getSex());
            maxCP = getMax(maxCP, dataList.get(i).getChestpain());
            maxTrestbps = getMax(maxTrestbps, dataList.get(i).getTrestbps());
            maxChol = getMax(maxChol, dataList.get(i).getChol());
            maxFbs = getMax(maxFbs, dataList.get(i).getFbs());
            maxRestecg = getMax(maxRestecg, dataList.get(i).getRestecg());
            maxThalach = getMax(maxThalach, dataList.get(i).getThalach());
            maxExang = getMax(maxExang, dataList.get(i).getExang());
            maxOldpeak = getMax(maxOldpeak, dataList.get(i).getOldpeak());
            maxSlope = getMax(maxSlope, dataList.get(i).getSlope());
            maxCa = getMax(maxCa, dataList.get(i).getCa());
            maxThal = getMax(maxThal, dataList.get(i).getThal());

            minAge = getMin(minAge, dataList.get(i).getAge());
            minSex = getMin(minSex, dataList.get(i).getSex());
            minCP = getMin(minCP, dataList.get(i).getChestpain());
            minTrestbps = getMin(minTrestbps, dataList.get(i).getTrestbps());
            minChol = getMin(minChol, dataList.get(i).getChol());
            minFbs = getMin(minFbs, dataList.get(i).getFbs());
            minRestecg = getMin(minRestecg, dataList.get(i).getRestecg());
            minThalach = getMin(minThalach, dataList.get(i).getThalach());
            minExang = getMin(minExang, dataList.get(i).getExang());
            minOldpeak = getMin(minOldpeak, dataList.get(i).getOldpeak());
            minSlope = getMin(minSlope, dataList.get(i).getSlope());
            minCa = getMin(minCa, dataList.get(i).getCa());
            minThal = getMin(minThal, dataList.get(i).getThal());
        }

        // Normalize all the attributes to range from 0-1 using x=(x-xMin)/(xMax-xMin)
        for (int i = 0; i < dataList.size(); i++)
        {
            dataList.get(i).setAge((dataList.get(i).getAge() - minAge) / (maxAge - minAge));
            dataList.get(i).setSex((dataList.get(i).getSex() - minSex) / (maxSex - minSex));
            dataList.get(i).setChestpain((dataList.get(i).getChestpain() - minCP) / (maxCP - minCP));
            dataList.get(i).setTrestbps((dataList.get(i).getTrestbps() - minTrestbps) / (maxTrestbps - minTrestbps));
            dataList.get(i).setChol((dataList.get(i).getChol() - minChol) / (maxChol - minChol));
            dataList.get(i).setFbs((dataList.get(i).getFbs() - minFbs) / (maxFbs - minFbs));
            dataList.get(i).setRestecg((dataList.get(i).getRestecg() - minRestecg) / (maxRestecg - minRestecg));
            dataList.get(i).setThalach((dataList.get(i).getThalach() - minThalach) / (maxThalach - minThalach));
            dataList.get(i).setExang((dataList.get(i).getExang() - minExang) / (maxExang - minExang));
            dataList.get(i).setOldpeak((dataList.get(i).getOldpeak() - minOldpeak) / (maxOldpeak - minOldpeak));
            dataList.get(i).setSlope((dataList.get(i).getSlope() - minSlope) / (maxSlope - minSlope));
            dataList.get(i).setCa((dataList.get(i).getCa() - minCa) / (maxCa - minCa));
            dataList.get(i).setThal((dataList.get(i).getThal() - minThal) / (maxThal - minThal));
        }

        // list of Euclidean distances between training datapoints and new datapoint
        ArrayList<Double> distanceList = new ArrayList<Double>();

        // calculate Euclidean distances between
        // all training datapoints (a) and the new datapoint (b)
        // and add to distanceList
        for (int i = 0; i < dataList.size() - 1; i++)
        {
            double a1 = dataList.get(i).getAge();
            double a2 = dataList.get(i).getSex();
            double a3 = dataList.get(i).getChestpain();
            double a4 = dataList.get(i).getTrestbps();
            double a5 = dataList.get(i).getChol();
            double a6 = dataList.get(i).getFbs();
            double a7 = dataList.get(i).getRestecg();
            double a8 = dataList.get(i).getThalach();
            double a9 = dataList.get(i).getExang();
            double a10 = dataList.get(i).getOldpeak();
            double a11 = dataList.get(i).getSlope();
            double a12 = dataList.get(i).getCa();
            double a13 = dataList.get(i).getThal();

            double b1 = dataList.get(dataList.size() - 1).getAge();
            double b2 = dataList.get(dataList.size() - 1).getSex();
            double b3 = dataList.get(dataList.size() - 1).getChestpain();
            double b4 = dataList.get(dataList.size() - 1).getTrestbps();
            double b5 = dataList.get(dataList.size() - 1).getChol();
            double b6 = dataList.get(dataList.size() - 1).getFbs();
            double b7 = dataList.get(dataList.size() - 1).getRestecg();
            double b8 = dataList.get(dataList.size() - 1).getThalach();
            double b9 = dataList.get(dataList.size() - 1).getExang();
            double b10 = dataList.get(dataList.size() - 1).getOldpeak();
            double b11 = dataList.get(dataList.size() - 1).getSlope();
            double b12 = dataList.get(dataList.size() - 1).getCa();
            double b13 = dataList.get(dataList.size() - 1).getThal();

            double distance = Math.sqrt(Math.pow(a1 - b1, 2) + Math.pow(a2 - b2, 2) + Math.pow(a3 - b3, 2)
                    + Math.pow(a4 - b4, 2) + Math.pow(a5 - b5, 2) + Math.pow(a6 - b6, 2) + Math.pow(a7 - b7, 2)
                    + Math.pow(a8 - b8, 2) + Math.pow(a9 - b9, 2) + Math.pow(a10 - b10, 2) + Math.pow(a11 - b11, 2)
                    + Math.pow(a12 - b12, 2) + Math.pow(a13 - b13, 2));
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

        int disease = 0;
        int healthy = 0;

        // loops until there is a majority in K
        while (true)
        {
            disease = 0;
            healthy = 0;

            // Find labels of K nearestNeighbors using indicies
            // related ti dataList
            for (int i = 0; i < K; i++)
            {
                switch (dataList.get(nearestNeighborIndicies.get(i)).getTarget())
                {
                case 0:
                    healthy++;
                    break;
                case 1:
                    disease++;
                    break;
                default:
                    System.out.println("That's not good tbqhwy famalam"); // label system broke...
                }
            }

            // Assign label based on majority K and break while loop
            if (healthy > disease)
            {
                dataList.get(dataList.size() - 1).setTarget(0);
                break;
            }
            else if (disease > healthy)
            {
                dataList.get(dataList.size() - 1).setTarget(1);
                break;
            }
            else
                K--; // reduce K by 1 and try again if there was no single majority
        }

        // Output results for user
        System.out.println("K(" + K + ") Nearest Neighbors are: " + healthy + " healthy and " + disease + " diseased.");
        System.out.print("Subject's heart is likely: ");
        if(dataList.get(dataList.size() - 1).getTarget()==0)
            System.out.println("healthy");
        else
            System.out.println("diseased");

    } // end main method
}