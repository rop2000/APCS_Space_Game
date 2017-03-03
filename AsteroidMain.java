package AsteroidGame;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AsteroidMain extends JPanel implements Runnable, KeyListener {

	long frameLength;
	long startingTime;
	long endTime;
	long st; 
	long et; 
	
	int time; 
	int duration; 
	int delta; 
	
	Thread t;
	int x;
	int xVelocity;
	int yVelocity;
	int y;
	Dimension dim;
	Image backbuffer;
	public Graphics gr;
	Spaceship spaceship;
	Color ship;
	boolean paused;
	Lasers[] lasers;
	int numberOfLasers;
	boolean shooting;
	int lives;
	private JPanel panel_4;
	Timer timer;
	Color temp;
	Asteroid[] asteroids;
	int numberOfAsteroids;
	double asteroidRadius;
	double minAsteroidVelocity;
	double maxAsteroidVelocity;
	int asteroidHitsUntilBreak;
	int asteroidSplit;
	int level;
	private JPanel contentPane;
	
	//The StarPolygon class was borrowed from JShapes/star-p.com 
	
	StarPolygon s;
	StarPolygon d;
	StarPolygon f;
	StarPolygon h;
	StarPolygon j;
	StarPolygon k;
	StarPolygon l;
	int score; 
	Font ft; 
	Font fn;
	GameOver o;

	public void init() {
		resize(1500, 1500); // idk why this says deprecated. it still works.

		lasers = new Lasers[40];
		numberOfAsteroids = 0;
		level = 0;
		lives = 5;
		score = 0;
		time = 0; //timer things that might be used later. 
		duration = 600000; 
		delta = 1; 
		temp = this.getShipColor();
		o = new GameOver();
		asteroidRadius = 75;
		minAsteroidVelocity = .5;
		maxAsteroidVelocity = 5;
		asteroidHitsUntilBreak = 3;
		asteroidSplit = 2;
		ft = new Font("Arial Bold",Font.BOLD,20);
		fn = new Font("Arial Bold", Font.BOLD,80);
		s = new StarPolygon(400, 500, 10, 5, 6);
		d = new StarPolygon(1300, 310, 10, 5, 6);
		f = new StarPolygon(750, 100, 10, 5, 6);
		h = new StarPolygon(100, 330, 10, 5, 6);
		j = new StarPolygon(850, 720, 10, 5, 6);
		k = new StarPolygon(600, 1400, 10, 5, 6);
		l = new StarPolygon(250, 1250, 10, 5, 6);
		panel_4 = new JPanel();
		this.add(panel_4);
		this.add(o);
		
	
		
		endTime = 0;
		startingTime = 0;
		st = System.currentTimeMillis();
		frameLength = 25;
		addKeyListener(this);
		requestFocusInWindow();
		setFocusable(true);
		requestFocus();
		dim = getSize();
		backbuffer = createImage(dim.width, dim.height);
		gr = backbuffer.getGraphics();
		t = new Thread(this);
		t.start();
	}

	public void startNextLevel() {
		level++;

		if (level >= 3) {
			asteroidHitsUntilBreak = 4;
		}
		if (level >= 6) {
			asteroidHitsUntilBreak = 5;

		}
		if (level >= 9) {

			asteroidHitsUntilBreak = 6;

		}
		spaceship = new Spaceship(700, 475, 0, .35, .98, .1, 12, temp);
		numberOfLasers = 0;
		paused = false;
		shooting = false;
		asteroids = new Asteroid[level * (int) Math.pow(asteroidSplit, asteroidHitsUntilBreak - 1) + 1];
		numberOfAsteroids = level;
		for (int i = 0; i < numberOfAsteroids; i++)
			asteroids[i] = new Asteroid(Math.random() * dim.width, Math.random() * dim.height, asteroidRadius,
					minAsteroidVelocity, maxAsteroidVelocity, asteroidHitsUntilBreak, asteroidSplit);
	}

	@Override
	public void paint(Graphics g) {

		gr.setColor(Color.black);
		gr.fillRect(0, 0, 1500, 1500);
		gr.setColor(Color.white);
		gr.fillPolygon(s);
		gr.setColor(Color.white);
		gr.fillPolygon(d);
		gr.setColor(Color.white);
		gr.fillPolygon(f);
		gr.setColor(Color.white);
		gr.fillPolygon(h);
		gr.setColor(Color.white);
		gr.fillPolygon(j);
		gr.setColor(Color.white);
		gr.fillPolygon(k);
		gr.setColor(Color.white);
		gr.fillPolygon(l);

		for (int i = 0; i < numberOfLasers; i++) {
			lasers[i].draw(gr);
		}

		for (int i = 0; i < numberOfAsteroids; i++) {
			asteroids[i].draw(gr);
			spaceship.draw(gr);
		}
		gr.setColor(Color.cyan);
		gr.setFont(ft);
		gr.drawString("Level " + (level), 20, 20);
		gr.setColor(Color.red);
		gr.setFont(ft);
		gr.drawString("Lives: " + lives, 440, 20);
		gr.setColor(Color.GREEN);
		gr.setFont(ft);
		gr.drawString("Score: " + score, 860, 20);
		gr.setColor(Color.LIGHT_GRAY);
		g.drawImage(backbuffer, 0, 0, this);
			}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {
		for (;;) {
			startingTime = System.currentTimeMillis();

			if (numberOfAsteroids <= 0)
				startNextLevel();

			if (!paused) {
				spaceship.move(dim.width, dim.height);
				for (int i = 0; i < numberOfLasers; i++) {
					lasers[i].move(dim.width, dim.height);

					if (lasers[i].getLifeLeft() <= 0) {
						deleteLaser(i);
						i--;
					}
				}
				updateAsteroids();
				if (shooting && spaceship.canShoot()) {
					lasers[numberOfLasers] = spaceship.shoot();
					numberOfLasers++;
				}
			}

			repaint();
			try {
				endTime = System.currentTimeMillis();
				if (frameLength - (endTime - startingTime) > 0)
					Thread.sleep(frameLength - (endTime - startingTime));
			} catch (InterruptedException e) {
			}
		}
	}

	private void deleteLaser(int index) {
		numberOfLasers--;
		for (int i = index; i < numberOfLasers; i++)
			lasers[i] = lasers[i + 1];
		lasers[numberOfLasers] = null;
	}

	private void addAsteroid(Asteroid ast) {

		asteroids[numberOfAsteroids] = ast;
		numberOfAsteroids++;
	}

	private void deleteAsteroid(int index) {
		numberOfAsteroids--;
		for (int i = index; i < numberOfAsteroids; i++)
			asteroids[i] = asteroids[i + 1];
		asteroids[numberOfAsteroids] = null;
	}

	private void updateAsteroids() {
		for (int i = 0; i < numberOfAsteroids; i++) {

			asteroids[i].move(dim.width, dim.height);
			if (asteroids[i].shipCollision(spaceship)) {
				if (lives == 1) {
					level = 0; 
					lives = 5;
					score = 0; 
					System.out.println(lives);
					
				  
					gr.setColor(Color.RED);
					gr.setFont(fn);
					gr.drawString("GAME OVER", 750, 750);
					
					
					
				} else {
					level--;
					lives--;
					numberOfAsteroids = 0;
					if(score >= 500)
					{
						score -= 500;
						
					}
					else{
						
						score = 0; 
						
					}
				}
				return;
			}

			for (int j = 0; j < numberOfLasers; j++) {
				if (asteroids[i].shotCollision(lasers[j])) {
					deleteLaser(j);
					score += 10;
					if (asteroids[i].getHitsLeft() > 1) {
						for (int k = 0; k < asteroids[i].getNumSplit(); k++)
							addAsteroid(asteroids[i].SplitAsteroid(minAsteroidVelocity, maxAsteroidVelocity));
					}
					deleteAsteroid(i);
					j = numberOfLasers;
					i--;

				}
			}
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!spaceship.isActive() && !paused)
				spaceship.setActive(true);
			else {
				paused = !paused;
				if (paused)
					spaceship.setActive(false);
				else

					spaceship.setActive(true);
			}
		} else if (paused || !spaceship.isActive())
			return;
		else if (e.getKeyCode() == KeyEvent.VK_UP)
			spaceship.setAccelerating(true);
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			spaceship.setTurningLeft(true);
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			spaceship.setTurningRight(true);
		else if (e.getKeyCode() == KeyEvent.VK_SPACE)
			shooting = true;
	}

	@Override
	public void keyReleased(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_UP)
			spaceship.setAccelerating(false);
		else if (k.getKeyCode() == KeyEvent.VK_LEFT)
			spaceship.setTurningLeft(false);
		else if (k.getKeyCode() == KeyEvent.VK_RIGHT)
			spaceship.setTurningRight(false);
		else if (k.getKeyCode() == KeyEvent.VK_SPACE)
			shooting = false;
	}

	@Override
	public void keyTyped(KeyEvent k) {

	}

	public void setShipColor(Color d)
	{
		
		ship = d;
	}
	
	public Color getShipColor()
	{
		return ship; 
		
	}
	
	
	public static void main(String args[]) {

	}

}