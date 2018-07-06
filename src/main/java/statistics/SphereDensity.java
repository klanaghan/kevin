package statistics;


public class SphereDensity extends Density
{
    public SphereDensity(double inStandardDensity)
    {
        super(inStandardDensity);
    }

    @Override
    public double volume()
    {
      double d =  Math.PI*Math.pow(diameter(), 3);
      double e = 1.0/6.0*d;

        return (1.0/6.0) * Math.PI*Math.pow(diameter(), 3);
    }

    @Override
    public double deltaVolume()
    {
        return 3*volume()*deltaDiameter()/diameter();
    }

    private double deltaDiameter()
    {
        return getMeasurement("diameter").muTotal();
    }
/*
V = 1/6πD^3=
ρ = m/V  =

δV = 3V*δD/D  =
δm  =

δρ=ρ√((δm/m)2+(δV/V)2) =

Density of the material of the cylinder (brass) =

Density of Brass (standard)   =

%error  =
 */



    private double diameter()
    {
        return getMeasurement("diameter").avg();
    }





public static void main(String[] inArgs)
{
    SphereDensity sd = new SphereDensity(8.525);
    double mass[] = {30.6,	30.6,	30.6,	30.55,	30.55};
    double diameter[] = {1.88,	1.88,	1.88,	1.88,	1.88};

    sd.addMeasurement(mass, .1, "mass");
    sd.addMeasurement(diameter, .01, "diameter");

    System.out.println("Mass = " + sd.mass() + " deltaMass = " + sd.deltaMass());
    System.out.println("Diameter = " + sd.diameter() + " deltaDiameter = " + sd.deltaDiameter());
    System.out.println("Volume =" + sd.volume() + " deltaVolume =" + sd.deltaVolume());
    System.out.println("Density = " + sd.density() + " deltaDensity =" + sd.deltaDensity());
    System.out.println("PercentError = " + sd.percentError());




}


}
