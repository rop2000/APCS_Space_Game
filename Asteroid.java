package AsteroidGame;

import java.awt.*;
public class Asteroid {
double x;
double y;
double xVel;
double yVel;
double radius;
int hitsUntilBreak, split;

public Asteroid(double x,double y,double radius,double minVel,
 double maxVel,int hitsUntilBreak,int split){
 this.x = x;
 this.y = y;
 this.radius = radius;
 this.hitsUntilBreak = hitsUntilBreak; 
 this.split = split; 

 double velocity = minVel + Math.random()*(maxVel-minVel),
 d =2*Math.PI*Math.random();
 xVel=velocity*Math.cos(d);
 yVel=velocity*Math.sin(d);
 }
public void move(int screenWidth, int screenHeight){
 x+=xVel; 
 y+=yVel;
 if(x< 0-radius)
 x+=screenWidth+2*radius;
 else if(x>screenWidth+radius)
 x-=screenWidth+2*radius;
 if(y<0-radius)
 y+=screenHeight+2*radius;
 else if(y>screenHeight+radius)
 y-=screenHeight+2*radius;
 }

public void draw(Graphics g){
 GradientPaint graytowhite = new GradientPaint(0,0,Color.black,100, 0,Color.gray);
 
 g.setColor(Color.DARK_GRAY); 

 g.fillOval((int)(x-radius+.5),(int)(y-radius+.5),
 (int)(2*radius),(int)(2*radius));
 }

public Asteroid SplitAsteroid(double minVelocity,
 double maxVelocity){
 
 return new Asteroid(x,y,radius/Math.sqrt(split),
 minVelocity,maxVelocity,hitsUntilBreak-1,split);
 }

public boolean shipCollision(Spaceship ship){


 if(Math.pow(radius+ship.getRadius(),2) >
Math.pow(ship.getX()-x,2) + Math.pow(ship.getY()-y,2)
&& ship.isActive())
 return true;
 return false;
 }
public boolean shotCollision(Lasers laser){

 if(Math.pow(radius,2) > Math.pow(laser.getX()-x,2)+
 Math.pow(laser.getY()-y,2))
 return true;
 return false;
 }

public int getHitsLeft(){


 return hitsUntilBreak;
 }

public int getNumSplit(){
 return split;
 }
}