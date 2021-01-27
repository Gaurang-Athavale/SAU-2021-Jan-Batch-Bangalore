package com.au.spring;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Triangle {
	
	// Using List
	
//	private List<Point> points; 
//	
//	public List<Point> getPoints(){
//		return points;
//	}
//	
//	public void setPoints(List<Point> points){
//		this.points = points;
//	}
	
	
	// USING INDIVIDUAL VARIABLES
	/*private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}*/

	// USING MAP
	
//	private Map<String,Point> points1;
//
//	public Map<String, Point> getPoints() {
//		return points1;
//	}
//
//	public void setPoints(Map<String, Point> points1) {
//		this.points1 = points1;
//	}
	 
	
	// USING SET
	private HashSet<Point> points;

	public HashSet<Point> getPoints() {
			return points;
		}

	public void setPoints(HashSet<Point> points) {
			this.points = points;
		}

	public void draw() {
		
		// PRINT USING LISTS
		
//		for(Point point:points) {
//			System.out.println("PointA = "+point.getX()+","+point.getY());
//		}
		
		
		// PRINT USING INDIVIDUAL VARIABLES
		
		/*System.out.println("PointA"+getPointA().getX()+"PointA"+getPointA().getX());
		System.out.println("PointB"+getPointA().getX()+"PointB"+getPointB().getX());
		System.out.println("PointC"+getPointA().getX()+"PointC"+getPointC().getX());*/
		
		// PRINT USING MAP
		
//		System.out.println("PRINT USING MAP");
//		for(Map.Entry<String, Point> entry:points1.entrySet()) {
//			System.out.println(entry.getKey() + "\t" + entry.getValue().getX() +"\t" +entry.getValue().getY());
//		}
		
		// PRINT USING SET
		
		Iterator<Point> itr = points.iterator();
		while (itr.hasNext()) {
			Point temp = itr.next();
			System.out.println("X : " + temp.getX() + "\t Y : " + temp.getY());
		}
	}

}
