package statistics;


public class CylinderDensity extends Density
{

    public CylinderDensity(double inStandardDensity)
    {
        super(inStandardDensity);
    }

    /*
        m  =
    V = πD2h/4 =
    ρ = m/V  =

    δV = V√((2δD/D)2+(δh/h)2)  =
    δm  =

    δρ=ρ√((δm/m)2+(δV/V)2) =

    Density of the material of the cylinder (brass) =

    Density of brass (standard)   =

    %error  =
         */
    @Override
    public double volume()
    {
        double diameter = Math.PI * Math.pow(diameter(), 2) * height() / 4;
        return diameter;
    }

    @Override
    public double deltaVolume()
    {
        double ttt = Math.pow(2.0*deltaDiameter() / diameter(), 2) +
                Math.pow(deltaHeight()/height(),2 );

        return volume() * Math.sqrt(ttt);


    }

    public double deltaDiameter()
    {
        return getMeasurement("diameter").muTotal();
    }



    private double diameter()
    {
        return getMeasurement("diameter").avg();
    }

    private double height()
    {
        return getMeasurement("height").avg();
    }
     private double deltaHeight()
     {
         return getMeasurement("height").muTotal();
     }

    public static void main(String[] inArgs)
    {
        CylinderDensity sd = new CylinderDensity(8.525);
        double mass[] = {56.75,	56.7,	56.8,	56.8,	56.8};
        double height[] = {4.17,	4.18,	4.17,	4.18,	4.18};
        double diameter[] = {1.43,	1.43,	1.43,	1.43,	1.43};

        sd.addMeasurement(mass, .1, "mass");
        sd.addMeasurement(height, .01, "height");
        sd.addMeasurement(diameter, .01, "diameter");

        System.out.println("Mass = " + sd.mass() + " deltaMass = " + sd.deltaMass());
        System.out.println("Diameter = " + sd.diameter() + " deltaDiameter = " + sd.deltaDiameter());
        System.out.println("Volume =" + sd.volume() + " deltaVolume =" + sd.deltaVolume());
        System.out.println("Density = " + sd.density() + " deltaDensity =" + sd.deltaDensity());
        System.out.println("PercentError = " + sd.percentError());



    }
}
