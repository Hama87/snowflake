package Koch;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;


public class Snowflake extends Polygon{
	
	private static final long serialVersionUID = 5720461471782754196L;
	java.util.List<Point2D.Double> list = new ArrayList<Point2D.Double>();
	double length;	
	
	public Snowflake(double x, double y, double length, int iter){
		
		super();
		
		double height = length*Math.sqrt(3)/2;
				
		//starting points
		list.add(new Point2D.Double(x-length/2, y+height/3));
		list.add(new Point2D.Double(x+length/2, y+height/3));
		list.add(new Point2D.Double(x, y-height*2/3));
				
		this.length = length;
		
		//do number of requested iterations
		for(int i=0; i<iter; i++){
			iteration();
		}
		
		//convert ArrayList to polygon points
		for(int i=0 ; i<list.size(); i++){
			addPoint((int)list.get(i).x, (int)list.get(i).y);
		}
	}
	
	void iteration(){
		
		//edge length reduced in every iteration
		length = length/3;
		
		
		for(int i=list.size()-1; i>0; i--){
			//remove line, add 4 shorter lines --> set 3 new points			
			double angle = get_angle(list.get(i), list.get(i-1));
			
			list.add(i, new Point2D.Double(list.get(i).x+length*Math.sin(angle), list.get(i).y+length*Math.cos(angle)));
			
			angle = angle + Math.toRadians(60);
			list.add(i, new Point2D.Double(list.get(i).x+length*Math.sin(angle), list.get(i).y+length*Math.cos(angle)));
			
			angle = angle - Math.toRadians(120);
			list.add(i, new Point2D.Double(list.get(i).x+length*Math.sin(angle), list.get(i).y+length*Math.cos(angle)));
		
		}
		
		//last iteration needs special treatment
		double angle = get_angle(list.get(0), list.get(list.size()-1));
		list.add(0, new Point2D.Double(list.get(0).x+length*Math.sin(angle), list.get(0).y+length*Math.cos(angle)));
		
		angle = angle + Math.toRadians(60);
		list.add(0, new Point2D.Double(list.get(0).x+length*Math.sin(angle), list.get(0).y+length*Math.cos(angle)));
		
		angle = angle - Math.toRadians(120);
		list.add(0, new Point2D.Double(list.get(0).x+length*Math.sin(angle), list.get(0).y+length*Math.cos(angle)));

		
	}
	
	double get_angle(Point2D.Double p1, Point2D.Double p2){
		
		double dx = p1.x - p2.x;
		double dy = p1.y - p2.y;
		
		//if at least one distance is zero
		if(dx == 0 && dy == 0) return 0;
		if(dx == 0 && dy > 0) return 0;
		if(dx == 0 && dy < 0) return Math.toRadians(180);
		if(dx > 0 && dy == 0) return Math.toRadians(270);
		if(dx < 0 && dy == 0) return Math.toRadians(90);
		
		//4 quadrants
		double angle = 0;
		if(dx > 0 && dy > 0) angle = Math.toRadians(180) + Math.atan(Math.abs(dx)/Math.abs(dy));
		if(dx < 0 && dy > 0) angle = Math.toRadians(180) - Math.atan(Math.abs(dx)/Math.abs(dy));
		if(dx > 0 && dy < 0) angle = Math.toRadians(360) - Math.atan(Math.abs(dx)/Math.abs(dy));
		if(dx < 0 && dy < 0) angle = Math.atan(Math.abs(dx)/Math.abs(dy));

		return angle;
	}
}
