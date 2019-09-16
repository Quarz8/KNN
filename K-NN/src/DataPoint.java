// Course:          CS4267
// Student name:    Warren Davis
// Student ID:      000545250
// Assignment #:    #1
// Due Date:        September 16, 2019
// Signature:       _________________
// Score:           _________________

public class DataPoint
{
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private String label = "";

    /** Constructors */
    DataPoint(double sLength, double sWidth, double pLength, double pWidth, String type) // labeled data point
    {
        sepalLength = sLength;
        sepalWidth = sWidth;
        petalLength = pLength;
        petalWidth = pWidth;
        label = type;
    }

    DataPoint(double sLength, double sWidth, double pLength, double pWidth) // unlabeled data point
    {
        sepalLength = sLength;
        sepalWidth = sWidth;
        petalLength = pLength;
        petalWidth = pWidth;
    }

    /** Getter methods for every variable */
    public double getSepalLength()
    {
        return sepalLength;
    }

    public double getSepalWidth()
    {
        return sepalWidth;
    }

    public double getPetalLength()
    {
        return petalLength;
    }

    public double getPetalWidth()
    {
        return petalWidth;
    }

    public String getLabel()
    {
        return label;
    }

    /** Setter methods for every variable */
    public void setSepalLength(double newSL)
    {
        this.sepalLength = newSL;
    }

    public void setSepalWidth(double newSW)
    {
        this.sepalWidth = newSW;
    }

    public void setPetalLength(double newPL)
    {
        this.petalLength = newPL;
    }

    public void setPetalWidth(double newPW)
    {
        this.petalWidth = newPW;
    }

    public void setLabel(String newLabel)
    {
        this.label = newLabel;
    }
}
