// Course:          CS4267
// Student name:    Warren Davis
// Student ID:      000545250
// Assignment #:    #1
// Due Date:        September 16, 2019
// Signature:       _________________
// Score:           _________________

public class DataPoint
{
    private double age; // in years
    private double sex; // 1=male, 0=female
    private double chestpain; // 0-3
    private double trestbps; // resting blood pressure in mm Hg
    private double chol; // serum cholestoral in mg/dl
    private double fbs; // fasting blood sugar>120mg/dl (1=true, 0=false)
    private double restecg; // resting electrocardiographic results (0-2)
    private double thalach; // maximum heartrate achieved
    private double exang; // exercise induced angina (1=yes 0=no)
    private double oldpeak; // ST depression induced by exercise relative to rest
    private double slope; // slope of peak exercise ST segment
    private double ca; // number of major vessels colored by flurosopy (0-3)
    private double thal; // 0-3
    private int target = 0; // 1=disease 0=no disease

    /** Constructors */
    DataPoint(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, double a10, int a11, int a12,
            int a13, int label) // labeled data point
    {
        age = a1;
        sex = a2;
        chestpain = a3;
        trestbps = a4;
        chol = a5;
        fbs = a6;
        restecg = a7;
        thalach = a8;
        exang = a9;
        oldpeak = a10;
        slope = a11;
        ca = a12;
        thal = a13;
        target = label;
    }

    DataPoint(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, double a10, int a11, int a12,
            int a13) // unlabeled data point
    {
        age = a1;
        sex = a2;
        chestpain = a3;
        trestbps = a4;
        chol = a5;
        fbs = a6;
        restecg = a7;
        thalach = a8;
        exang = a9;
        oldpeak = a10;
        slope = a11;
        ca = a12;
        thal = a13;
    }

    public double getAge()
    {
        return age;
    }

    public double getSex()
    {
        return sex;
    }

    public double getChestpain()
    {
        return chestpain;
    }

    public double getTrestbps()
    {
        return trestbps;
    }

    public double getChol()
    {
        return chol;
    }

    public double getFbs()
    {
        return fbs;
    }

    public double getRestecg()
    {
        return restecg;
    }

    public double getThalach()
    {
        return thalach;
    }

    public double getExang()
    {
        return exang;
    }

    public double getOldpeak()
    {
        return oldpeak;
    }

    public double getSlope()
    {
        return slope;
    }

    public double getCa()
    {
        return ca;
    }

    public double getThal()
    {
        return thal;
    }

    public int getTarget()
    {
        return target;
    }

    public void setAge(double age)
    {
        this.age = age;
    }

    public void setSex(double sex)
    {
        this.sex = sex;
    }

    public void setChestpain(double chestpain)
    {
        this.chestpain = chestpain;
    }

    public void setTrestbps(double trestbps)
    {
        this.trestbps = trestbps;
    }

    public void setChol(double chol)
    {
        this.chol = chol;
    }

    public void setFbs(double fbs)
    {
        this.fbs = fbs;
    }

    public void setRestecg(double restecg)
    {
        this.restecg = restecg;
    }

    public void setThalach(double thalach)
    {
        this.thalach = thalach;
    }

    public void setExang(double exang)
    {
        this.exang = exang;
    }

    public void setOldpeak(double oldpeak)
    {
        this.oldpeak = oldpeak;
    }

    public void setSlope(double slope)
    {
        this.slope = slope;
    }

    public void setCa(double ca)
    {
        this.ca = ca;
    }

    public void setThal(double thal)
    {
        this.thal = thal;
    }

    public void setTarget(int target)
    {
        this.target = target;
    }
}