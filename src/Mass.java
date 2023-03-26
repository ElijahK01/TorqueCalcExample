public class Mass {
	
	double x;
	double y;
	double mass;
	
	public Mass()
	{
		this.x = 0;
		this.y = 0;
		this.mass = 1;
	}
	
	public Mass(double x, double y, double mass)
	{
		this.x = x;
		this.y = y;
		this.mass = mass;
	}
	
	public double returnX() {return this.x;}
	public double returnY() {return this.y;}
	public double returnMass() {return this.mass;}
}
