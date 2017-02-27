package AsteroidGame;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;

public class ExtraLife {
	double x;
	double y;
	double radius;
	
	public ExtraLife(double x,double y,double radius)
	{
			 this.x = x;
			 this.y = y;
			 this.radius = radius;
	}
	
	public void draw(Graphics g){
		 GradientPaint graytowhite = new GradientPaint(0,0,Color.black,100, 0,Color.gray);
		 
		 g.setColor(Color.red); 

		 g.fillOval((int)(x-radius+.5),(int)(y-radius+.5),
		 (int)(2*radius),(int)(2*radius));
		 }
	
	
	public boolean shipCollision(Spaceship ship){
		 if(Math.pow(radius+ship.getRadius(),2) >
		Math.pow(ship.getX()-x,2) + Math.pow(ship.getY()-y,2)
		&& ship.isActive())
		 return true;
		 return false;
		 }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
