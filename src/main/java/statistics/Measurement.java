package statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class Measurement extends DescriptiveStatistics
{
    private Double instrumentError;

    public Measurement(Double inInstrumentError)
    {
        instrumentError = inInstrumentError;
    }

    public double muA()
   {
       return getStandardDeviation();
   }
   public double muB()
   {
      // 0.1/(2*SQRT(6))
       return instrumentError/(2.0 * Math.sqrt(6.0));
   }


    public double avg()
    {
        return this.getMean();
    }
    public double muTotal()
    {
        return Math.sqrt(Math.pow(muA(),2) + Math.pow(muB(), 2));
    }


}
