import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class gets masses on a pivot and calculates the max torque needed to keep the objects 
 * stationary of pivot is @ (0, 0)
 */

public class TourqueCalc {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input Mode: polar (p) | x/y (c)\n"
				+ "Press x to finish and calculate\n"
				+ "Input as x/radius, y/angle, mass");
		boolean mode = (input.nextLine().contains("p") ? true : false);
		
		String inputStr = input.nextLine();
		ArrayList<Vector> vecList = new ArrayList<Vector>();
		
		while(!inputStr.contains("x"))
		{
			
			inputStr.replaceAll(" ", ""); // remove any spaces
			
			double param1 = Double.valueOf(inputStr.split(",")[0]);
			double param2 = Double.valueOf(inputStr.split(",")[1]);
			double mass   = Double.valueOf(inputStr.split(",")[2]);
			
			if(mode)
				vecList.add(new Vector(param2, param2, mass));
			else
				vecList.add(VectorMath.scaleVector(VectorMath.cartesianToVector(param1, param2), mass));
			
			inputStr = input.nextLine().trim();
		}

		Vector v_avg = VectorMath.average(vecList);
		System.out.println("\nCenter of gravity stats\n\nAngle(degrees): " + v_avg.returnAngle()*(180.0/Math.PI) + "\nRadius: " + v_avg.returnRadius());
		System.out.println("Max Tourque needed: " + v_avg.returnRadius());
		input.close();
	}
}
