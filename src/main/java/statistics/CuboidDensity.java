package statistics;


public class CuboidDensity extends Density
{

    public CuboidDensity(double inStandardDensity)
    {
        super(inStandardDensity);
    }

    /*V = wLh
ρ = m/V  =

δV = V√((δw/W)2+(δL/L)^2 +(δh/h)2)  =
δm  =

δρ=ρ√((δm/m)2+(δV/V)2) =         */
    @Override
    public double volume()
    {
        double volume = value("width")* value("length") * value("height");
        return volume;
    }

    @Override
    public double deltaVolume()
    {
        double ttt = volume() * Math.sqrt(
                 Math.pow(delta("width")/value("width"),2)
               + Math.pow(delta("length")/value("length"),2)
               + Math.pow(delta("length")/value("length"),2)
        );


        return ttt;


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
        CuboidDensity sd = new CuboidDensity(2.715);
        double mass[] = {43,	43,	43,	43,	43.1};
        double height[] = {4.96,	4.96,	4.96,	4.96,	4.96,	4.96};
        double width[] = {1.38,	1.38,	1.38,	1.37,	1.37};
        double length[] = {2.54,	2.54,	2.54,	2.54,	2.54};


        sd.addMeasurement(mass, .1, "mass");
        sd.addMeasurement(height, .01, "height");
        sd.addMeasurement(width, .01, "width");
        sd.addMeasurement(length, .01, "length");


        System.out.println("Mass = " + sd.mass() + " deltaMass = " + sd.deltaMass());
        System.out.println("Height = " + sd.value("height") + " deltaHeight = " + sd.delta("height"));
        System.out.println("Width = " + sd.value("width") + " deltaHeight = " + sd.delta("width"));
        System.out.println("Length = " + sd.value("length") + " deltaLength = " + sd.delta("length"));

        System.out.println("Volume =" + sd.volume() + " deltaVolume =" + sd.deltaVolume());
        System.out.println("Density = " + sd.density() + " deltaDensity =" + sd.deltaDensity());
        System.out.println("PercentError = " + sd.percentError());



    }
    public static void micrometer()
    {
        CuboidDensity sd = new CuboidDensity(.002715);
        double mass[] = {43,	43,	43,	43,	43.1};
        double height[] = {49.6,	49.6,	4.96,	4.96,	4.96,	4.96};
        double width[] = {13.8,	13.8,	13.8,	13.7,	13.7};
        double length[] = {2.54,	2.54,	2.54,	2.54,	2.54};


        sd.addMeasurement(mass, .1, "mass");
        sd.addMeasurement(height, .01, "height");
        sd.addMeasurement(width, .01, "width");
        sd.addMeasurement(length, .01, "length");


        System.out.println("Mass = " + sd.mass() + " deltaMass = " + sd.deltaMass());
        System.out.println("Height = " + sd.value("height") + " deltaHeight = " + sd.delta("height"));
        System.out.println("Width = " + sd.value("width") + " deltaHeight = " + sd.delta("width"));
        System.out.println("Length = " + sd.value("length") + " deltaLength = " + sd.delta("length"));

        System.out.println("Volume =" + sd.volume() + " deltaVolume =" + sd.deltaVolume());
        System.out.println("Density = " + sd.density() + " deltaDensity =" + sd.deltaDensity());
        System.out.println("PercentError = " + sd.percentError());



    }
}
