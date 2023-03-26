public class Vector {
	double radius;
	double angle;
	
	public Vector()
	{
		this.radius = 0;
		this.angle = 0;
	}
	
	public Vector(double radius, double angle)
	{
		this.radius = radius;
		this.angle = angle;
	}
	
	public Vector(double radius, double angle, double mass) // normalizes mass
	{
		this.radius = radius * mass;
		this.angle = angle;
	}
	
	
	public double returnRadius() {return this.radius;}
	
	public double returnAngle() {return this.angle;}
	
}
