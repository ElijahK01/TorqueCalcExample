import java.util.ArrayList;

public class VectorMath {
	public static Vector cartesianToVector(double x, double y)
	{
		double r = 0.0;
		double a = 0.0;
		
		// convert to polar
		r = Math.sqrt((x * x) + (y * y));
		a = Math.atan(y/x);
		
		return new Vector(r, a);
	}
	
	public static double[] vectorToCartesian(Vector v)
	{
		double x = 0.0;
		double y = 0.0;
		
		// convert to cartesian
		x = v.returnRadius() * Math.cos(v.returnAngle());
		y = v.returnRadius() * Math.sin(v.returnAngle());
		
		return new double[] {x, y};
	}
	
	public static double vectorX(Vector v)
	{
		// convert to cartesian
		return v.returnRadius() * Math.cos(v.returnAngle());
	}
	
	public static double vectorY(Vector v)
	{
		// convert to cartesian
		return v.returnRadius() * Math.sin(v.returnAngle());
	}
	
	public static Vector scaleVector(Vector v, double scale)
	{
		return new Vector(v.returnRadius() * scale, v.returnAngle());
	}
	
	public static Vector sum(Vector v1, Vector v2)
	{
		double x = vectorX(v1) + vectorX(v2);
		double y = vectorY(v1) + vectorY(v2);
		
		return cartesianToVector(x, y);
	}
	
	public static Vector sum(ArrayList<Vector> vecs)
	{
		double x = 0;
		double y = 0;
		
		while(!vecs.isEmpty())
		{
			Vector v = vecs.get(0);
			
			x += vectorX(v);
			y += vectorY(v);
			
			vecs.remove(0);
		}
		
		return cartesianToVector(x, y);
	}

	public static Vector average(Vector v1, Vector v2)
	{
		double x = (vectorX(v1) + vectorX(v2)) / 2;
		double y = (vectorY(v1) + vectorY(v2)) / 2;

		return cartesianToVector(x, y);
	}

	public static Vector average(ArrayList<Vector> vecs)
	{
		int arraySize = vecs.size();
		double x = 0;
		double y = 0;

		while(!vecs.isEmpty())
		{
			Vector v = vecs.get(0);

			x += vectorX(v);
			y += vectorY(v);

			vecs.remove(0);
		}

		return cartesianToVector((x/arraySize), (y/arraySize));
	}
}
