package statistics;

import java.util.HashMap;
import java.util.Map;


public abstract class Density
{
   Map<String, Measurement> map = new HashMap<>();
   private double standardDensity;

    public Density(double inStandardDensity)
    {
        standardDensity = inStandardDensity;
    }

    public void addMeasurement(double[] inputArray, double instrumentError, String type)
    {
        Measurement m = new Measurement(instrumentError);

        for (int i = 0; i < inputArray.length; i++)
        {
            m.addValue(inputArray[i]);
        }
        map.put(type, m);

  }

  public Measurement getMeasurement(String inKey)
  {
      return map.get(inKey);
  }


    public abstract double volume();
    public abstract double deltaVolume();

    public double delta(String inParam)
    {
        return getMeasurement(inParam).muTotal();
    }
    public double value(String inParam)
    {
        return getMeasurement(inParam).avg();
    }


    public double density()
    {
        return mass()/volume();
    }

    public double mass()
    {
        return getMeasurement("mass").avg();
    }

    public double percentError()
    {
        return Math.abs( (density() - standardDensity)/standardDensity)*100.0;
    }
    public double deltaMass()
    {
        return getMeasurement("mass").muTotal();
    }

    public double deltaDensity()
    {
        //δρ=ρ√((δm/m)2+(δV/V)2) =
        double d1 = Math.pow(deltaMass()/ mass(),2);
        double v1 = Math.pow(deltaVolume()/ volume(),2);

        return density()*Math.sqrt(d1 + v1);
    }

}
