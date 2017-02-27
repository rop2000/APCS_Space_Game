package AsteroidGame;
import java.awt.*; 
public class Spaceship {
	final double[] origShipXPos={14,-10,-6,-10};
	final double[] origShipYPos={0,-8,0,8};
	final double[] origShipFlameXPos={-6,-23,-6};
	final double[] origShipFlameYPos={-3,0,3};
	final int radius=6;
    double x;
    double y;
    double angle;
    double xVel;
    double yVel;
    double acceleration;
    double DecayRateVelocity; 
    double SpeedofRotation; 
    
			
	boolean accelerating; 
	boolean active;
	boolean turningLeft; 
	boolean turningRight; 
	
		
			int[] xPts, yPts, flameXPts, flameYPts;
			int laserDelay;
			int laserDelayLeft;

			public Spaceship(double x, double y, double angle, double acceleration,
			 double DecayRateVelocity, double SpeedofRotation,
			 int laserDelay){
			
			 this.x=x;
			 this.y=y;
			 this.angle=angle;
			 this.acceleration=acceleration;
			 this.DecayRateVelocity=DecayRateVelocity;
			 this.SpeedofRotation=SpeedofRotation;
			 xVel=0; 
			 yVel=0;
			 turningLeft=false; 
			 turningRight=false;
			 accelerating=false; 
			 active=false; 
		
			 xPts=new int[4]; 
			 yPts=new int[4];
			 flameXPts=new int[3];
			 flameYPts=new int[3];
			 this.laserDelay=laserDelay; 
			 laserDelayLeft=0; 
			 }

			public void draw(Graphics g){
			 if(accelerating && active){ 
			 for(int i=0;i<3;i++){
			 flameXPts[i]=(int)(origShipFlameXPos[i]*Math.cos(angle)-
			 origShipFlameYPos[i]*Math.sin(angle)+
			 x+.5);
			 flameYPts[i]=(int)(origShipFlameXPos[i]*Math.sin(angle)+
			 origShipFlameYPos[i]*Math.cos(angle)+
			 y+.5);
			 }
			 g.setColor(Color.red); 
			 g.fillPolygon(flameXPts,flameYPts,3); 
			 }
			
			 for(int i=0;i<4;i++){
			 xPts[i]=(int)(origShipXPos[i]*Math.cos(angle)- 
			 origShipYPos[i]*Math.sin(angle)+ x+0.5); 
			 yPts[i]=(int)(origShipXPos[i]*Math.sin(angle)+ 
			 origShipYPos[i]*Math.cos(angle)+ y+0.5); 
			 }
			 if(active) 
			 g.setColor(Color.getHSBColor(99, 123, 123));
			 else 
			 g.setColor(Color.darkGray);
			 g.fillPolygon(xPts,yPts,4); 
			 }

			public void move(int screenWidth, int screenHeight){
			 if(laserDelayLeft>0) 
			 laserDelayLeft--; 
			 if(turningLeft) 
			 angle-=SpeedofRotation;
			 if(turningRight)
			 angle+=SpeedofRotation;
			 if(angle>(2*Math.PI)) 
			 angle-=(2*Math.PI);
			 else if(angle<0)
			 angle+=(2*Math.PI);
			 if(accelerating){ 
			 
			 xVel+=acceleration*Math.cos(angle);
			 yVel+=acceleration*Math.sin(angle);
			 }
			 x+=xVel; 
		
			 y+=yVel;
			 xVel*=DecayRateVelocity; 
			 yVel*=DecayRateVelocity; 
			 //This code snippet is a modified version of one from a tutorial. Ensures that objects
			 //loop on screen and show up equally as they cross the screen border.
			 if(x<0) 
			 x+=screenWidth; 
			 else if(x>screenWidth)
			 x-=screenWidth;
			 if(y<0)
			 y+=screenHeight;
			 else if(y>screenHeight)
			 y-=screenHeight;
			 }
			//End of Snippet
			public void setAccelerating(boolean accelerating){
			 this.accelerating=accelerating;
			 }

			public void setTurningLeft(boolean turningLeft){
			 this.turningLeft=turningLeft;
			 }

			public void setTurningRight(boolean turningRight){
			 this.turningRight=turningRight;
			 }

			public double getX(){
			 return x;
			 }

			public double getY(){
			 return y;
			 }

			public double getRadius(){
			 return radius;
			 }

			public void setActive(boolean active){
			 this.active=active;
			 }

			public boolean isActive(){
			 return active;
			 }

			public boolean canShoot(){
			 if(laserDelayLeft>0)
			 return false; 
			 else
			 return true;
			 }
			public Lasers shoot(){
			 laserDelayLeft=laserDelay;
			 return new Lasers(x,y,angle,xVel,yVel,100);
			 
			}
			
}