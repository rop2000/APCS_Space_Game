package AsteroidGame;
import java.awt.*; 
public class Lasers {
	final double laserSpeed=12;
	double x,y,xVel,yVel;
	int lifeLeft;

	public Lasers(double x, double y, double angle, double spaceshipXVelocity,
	 double spaceshipYVelocity, int lifeLeft)
	{
	 this.x=x;
	 this.y=y;
	 this.lifeLeft=lifeLeft;
	 xVel=laserSpeed*Math.cos(angle)+spaceshipXVelocity;
	 yVel=laserSpeed*Math.sin(angle)+spaceshipYVelocity;
	 }

	
	//This code snippet is a modified version of one from a tutorial on stack overflow. Ensures that objects
	 //loop on screen and show up equally as they cross the screen border.
	public void move(int screenWidth, int screenHeight){
	 lifeLeft--; 
	
	 x+=xVel; 
	 y+=yVel;
	 if(x<0) 
	 x+=screenWidth; 
	 else if(x>screenWidth)
	 x-=screenWidth;
	 if(y<0)
	 y+=screenHeight;
	 else if(y>screenHeight)
	 y-=screenHeight;
	 }

	public void draw(Graphics g){
	 g.setColor(Color.RED); 
	 g.fillOval((int)(x-.5), (int)(y-.5), 5, 5);
	 }

	public double getX(){
	 return x;
	 }

	public double getY(){
	 return y;
	 }

	public int getLifeLeft(){
	 return lifeLeft;
	 } 
}
